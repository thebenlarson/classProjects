/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.vendingmachine.dao;

import com.bl.vendingmachine.dto.VendingItem;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DataFormatter;
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
public class VendingMachineAuditDaoExcelImpl implements VendingMachineAuditDao{
    private final String SHEET_NAME = "Audit";
    private final String NAME = "audit.xlsx";
    

    @Override
    public void writeAuditEntry(String entry) throws VendingMachinePersistenceException {

        try {
            //Note: Read file first to get the row count
            FileInputStream file = new FileInputStream(new File(NAME));
            Workbook workbook = new XSSFWorkbook(file);
            DataFormatter dataFormatter = new DataFormatter();
            Sheet sheet = workbook.getSheet(SHEET_NAME);
            LocalDateTime timestamp = LocalDateTime.now();
            
            Font headerFont = workbook.createFont();
            headerFont.setFontHeightInPoints((short)12);
            headerFont.setColor(IndexedColors.BLACK.index);
            
            CellStyle headerStyle = workbook.createCellStyle();
            headerStyle.setFont(headerFont);
            headerStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.index);
            
            int rownum = sheet.getLastRowNum();
            file.close();
            
            Row row = sheet.createRow(++rownum);
            row.createCell(0).setCellValue(entry);
            row.createCell(1).setCellValue(timestamp.toString());
           
            //Write the output to file
            FileOutputStream fileOut = new FileOutputStream(NAME);
            workbook.write(fileOut);
            fileOut.close();
            System.out.println("Completed");
        } catch (Exception e){
            e.printStackTrace();
        }

    }
    
}
