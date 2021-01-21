/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.vendingmachine.dao;

import com.bl.vendingmachine.dto.VendingItem;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author benth
 */
public class VendingMachineDaoExcelImpl implements VendingMachineDao {
    private HashMap<String, VendingItem> inventory = new HashMap<>();
    private BigDecimal money = new BigDecimal("0").setScale(2, RoundingMode.HALF_UP);
    private final String NAME = "inventory.xlsx";    
    private final String SHEET_NAME = "Inventory";

    @Override
    public List<VendingItem> getAllVendingItems(){
        return new ArrayList<>(inventory.values());
    }
    
    @Override
    public List<VendingItem> getInStockVendingItems(){
        return inventory.values().stream()
                .filter(v -> v.getStock() > 0)
                .collect(Collectors.toList());
    }
    
    @Override
    public VendingItem getOneVendingItem(String code) throws  VendingMachineInvalidCodeException{
        if(!inventory.containsKey(code.toUpperCase())){
            throw new VendingMachineInvalidCodeException("FAILURE: Code entered does not exist. Please Try Again.");
        }
        return inventory.get(code.toUpperCase());
    }
    
    @Override
    public VendingItem purchaseVendingItem(VendingItem item){
        money = money.subtract(item.getPrice());
        item.setStock(item.getStock() - 1);
        return item;
    }
    
    @Override
    public void addMoney(BigDecimal newMoney){
        money = money.add(newMoney).setScale(2, RoundingMode.HALF_UP);
    }
    
    @Override
    public String getBalanceString(){
        return money.toString();
    }
    
    @Override
    public BigDecimal getBalance(){
        return money;
    }
    
    @Override
    public HashMap<String, VendingItem> getInventory(){
        return inventory;
    }

    @Override
    public void loadInventory() throws VendingMachinePersistenceException {
        HashMap<Integer, String> line = new HashMap<>();
        try {
            FileInputStream file = new FileInputStream(new File(NAME));
            Workbook workbook = new XSSFWorkbook(file);
            DataFormatter dataFormatter = new DataFormatter();
            Sheet sheet = workbook.getSheet(SHEET_NAME);
            Iterator<Row> iterator = sheet.iterator();
            iterator.next();
            while (iterator.hasNext()){
                line.clear();
                Row row = iterator.next();
                Iterator<Cell> cellIterator = row.iterator();
                while (cellIterator.hasNext()){
                    Cell cell = cellIterator.next();
                    int index = cell.getColumnIndex();
                    String cellValue = dataFormatter.formatCellValue(cell);
                    line.put(index, cellValue);
                }
                unmarshallItem(line);
            }
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void writeInventory() throws VendingMachinePersistenceException {
        try {
            String[] columnHeadings = {"Code","Name","Price","Stock"};
            Workbook workbook = new XSSFWorkbook();
            Sheet sh = workbook.createSheet(SHEET_NAME);
            
            Font headerFont = workbook.createFont();
            headerFont.setFontHeightInPoints((short)12);
            headerFont.setColor(IndexedColors.BLACK.index);
            
            CellStyle headerStyle = workbook.createCellStyle();
            headerStyle.setFont(headerFont);
            headerStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.index);
            
            Row headerRow = sh.createRow(0);
            for(int i=0;i<columnHeadings.length;i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(columnHeadings[i]);
                cell.setCellStyle(headerStyle);
            }

            sh.createFreezePane(0, 1);

            int rownum = 1;
            for(VendingItem i : inventory.values()) {
                Row row = sh.createRow(rownum++);
                
                row.createCell(0).setCellValue(i.getCode());
                row.createCell(1).setCellValue(i.getName());
                row.createCell(2).setCellValue(i.getPriceString());
                row.createCell(3).setCellValue(i.getStock());
            }

            //Write the output to file
            FileOutputStream fileOut = new FileOutputStream(NAME);
            workbook.write(fileOut);
            fileOut.close();
            System.out.println("Completed");
        } catch (Exception e){
            e.printStackTrace();
        }
        
    }
    
    
    public void unmarshallItem(HashMap<Integer, String> line){
        String code = line.get(0);
        String name = line.get(1);
        String price = line.get(2);
        String stock = line.get(3);
        
        VendingItem item = new VendingItem(code);
        item.setName(name);
        item.setPriceString(price);
        item.setStockString(stock);
        
        inventory.put(code, item);
    }
}
