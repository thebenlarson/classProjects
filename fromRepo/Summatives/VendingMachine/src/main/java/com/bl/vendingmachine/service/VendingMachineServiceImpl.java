/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.vendingmachine.service;

import com.bl.vendingmachine.dao.*;
import com.bl.vendingmachine.dto.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 *
 * @author benth
 */
public class VendingMachineServiceImpl implements VendingMachineService{
    VendingMachineDao dao;
    VendingMachineAuditDao auditDao;
    
    public VendingMachineServiceImpl(VendingMachineDao dao, VendingMachineAuditDao auditDao){
        this.dao = dao;
        this.auditDao = auditDao;
    }
    
    public enum Coins {
        QUARTERS("25"), DIMES("10"), NICKELS("5"), PENNIES("1");
        
        private String text;

        Coins(String text) {
            this.text = text;
        }

        public String getText() {
            return this.text;
        }

        public static String calculateChange(String text) {
            String change = "Returns $" + text + " as ";
            BigDecimal balance = new BigDecimal(text);
            balance = balance.multiply(BigDecimal.TEN).multiply(BigDecimal.TEN);
            BigDecimal coins;
            for (Coins b : Coins.values()) {
                //calculate how much of each coin, then add to string
                coins = balance.divide(new BigDecimal(b.getText()), RoundingMode.FLOOR).setScale(0, RoundingMode.FLOOR);
                balance = balance.subtract(coins.multiply(new BigDecimal(b.getText())));
                change += coins.toString() + " " + b.name();
                if (b.getText().equals("1")){
                    change += ".";
                } else {
                    change += ", ";
                }
            }
            return change;
        }
    }
    
    @Override
    public List<VendingItem> getInStockVendingItems(){
        return dao.getInStockVendingItems();
    }
    
    @Override
    public List<VendingItem> getAllVendingItems(){
        return dao.getAllVendingItems();
    }
    
    @Override
    public void loadInventory() throws VendingMachinePersistenceException{
        dao.loadInventory();
    }
    
    public void writeInventory() throws VendingMachinePersistenceException{
        dao.writeInventory();
    }
    
    @Override
    public void addMoney(String money){
        BigDecimal newMoney = new BigDecimal(money).setScale(2, RoundingMode.HALF_UP);
        dao.addMoney(newMoney);
    }
    
    @Override
    public String getBalance(){
        return dao.getBalanceString();
    }
    
    @Override
    public VendingItem purchaseVendingItem(String code) throws 
            VendingMachineInsufficientFundsException,
            VendingMachineNoItemInventoryException,
            VendingMachineInvalidCodeException,
            VendingMachinePersistenceException
    {
        BigDecimal budget = dao.getBalance();
        
        VendingItem vendingItem = dao.getOneVendingItem(code);
        if (budget.compareTo(vendingItem.getPrice()) <= -1){
            throw new VendingMachineInsufficientFundsException("Insufficient funds. Please add Money");
        }
        if (vendingItem.getStock() <= 0){
            throw new VendingMachineNoItemInventoryException("Item is out of stock. Buy something else.");
        }
        auditDao.writeAuditEntry(vendingItem.getName());
        return dao.purchaseVendingItem(vendingItem);
    }
    
    @Override
    public void checkBalance() throws VendingMachineInsufficientFundsException{
        BigDecimal budget = dao.getBalance();
        if (budget.compareTo(BigDecimal.ZERO) == 0){
            throw new VendingMachineInsufficientFundsException("Add money before trying to purchase!");
        }
    }
    
    @Override
    public String getChange(){
        return Coins.calculateChange(dao.getBalanceString());
    }
}
