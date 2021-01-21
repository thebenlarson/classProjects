/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.vendingmachine.dao;

import com.bl.vendingmachine.dto.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author benth
 */
public class VendingMachineDaoFileImpl implements VendingMachineDao {
    private HashMap<String, VendingItem> inventory = new HashMap<>();
    private BigDecimal money = new BigDecimal("0").setScale(2, RoundingMode.HALF_UP);
    public static final String SAVE_FILE = "inventory.txt";
    public static final String DELIMITER = "::";
    
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
    
    private VendingItem unmarshallVendingItem(String vendingItemAsText){
        
        String[] vendingItemTokens = vendingItemAsText.split(DELIMITER);
        
        String vendingItemCode = vendingItemTokens[0];
        VendingItem vendingItemFromFile = new VendingItem(vendingItemCode);
        
        vendingItemFromFile.setName(vendingItemTokens[1]);
        vendingItemFromFile.setPriceString(vendingItemTokens[2]);
        vendingItemFromFile.setStockString(vendingItemTokens[3]);

        return vendingItemFromFile;
    }
    
    @Override
    public void loadInventory() throws VendingMachinePersistenceException {
        Scanner scanner;

        try {
            // Create Scanner for reading the file
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(SAVE_FILE)));
        } catch (FileNotFoundException e) {
            throw new VendingMachinePersistenceException(
                    "-_- Could not load inventory data into memory.", e);
        }
        String currentLine;
        VendingItem currentVendingItem;
        
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentVendingItem = unmarshallVendingItem(currentLine);
            inventory.put(currentVendingItem.getCode(), currentVendingItem);
        }

        scanner.close();
    }
    
    private String marshallVendingItem(VendingItem vendingItem){
        String vendingItemAsText = vendingItem.getCode() + DELIMITER;
        
        vendingItemAsText += vendingItem.getName()+ DELIMITER;
        vendingItemAsText += vendingItem.getPriceString()+ DELIMITER;
        vendingItemAsText += vendingItem.getStock();

        return vendingItemAsText;
    }
    
    @Override
   public void writeInventory() throws VendingMachinePersistenceException {
       PrintWriter out;

       try {
           out = new PrintWriter(new FileWriter(SAVE_FILE));
       } catch (IOException e) {
           throw new VendingMachinePersistenceException(
                   "Could not save vending item data.", e);
       }

       String vendingItemAsText;
       List<VendingItem> vendingItemsList = this.getAllVendingItems();
       for (VendingItem currentVendingItem : vendingItemsList) {
           vendingItemAsText = marshallVendingItem(currentVendingItem);
           out.println(vendingItemAsText);
           out.flush();
       }

       out.close();
   }
   
}
    
