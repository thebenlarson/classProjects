/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.vendingmachine.dao;

import com.bl.vendingmachine.dto.VendingItem;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author benth
 */
public class VendingMachineDaoStubImpl implements VendingMachineDao{
    VendingItem vendingItem, vendingItem2;
    BigDecimal money;
    HashMap<String, VendingItem> inventory = new HashMap<>();
    
    public VendingMachineDaoStubImpl(){
        vendingItem = new VendingItem("A1");
        vendingItem.setName("snack");
        vendingItem.setPriceString("1.00");
        vendingItem.setStock(2);
        
        vendingItem2 = new VendingItem("A2");
        vendingItem2.setName("snack2");
        vendingItem2.setPriceString("0.20");
        vendingItem2.setStock(0);
        
        money = new BigDecimal("0.00");
        
        inventory.put(vendingItem.getCode(), vendingItem);
        inventory.put(vendingItem2.getCode(), vendingItem2);
    }

    @Override
    public List<VendingItem> getAllVendingItems() {
        return new ArrayList<>(inventory.values());
    }

    @Override
    public List<VendingItem> getInStockVendingItems() {
        return inventory.values().stream().filter(i -> i.getStock() > 0).collect(Collectors.toList());
    }

    @Override
    public VendingItem getOneVendingItem(String code) throws VendingMachineInvalidCodeException {
        if(!inventory.containsKey(code.toUpperCase())){
            throw new VendingMachineInvalidCodeException("FAILURE: Code entered does not exist. Please Try Again.");
        }
        return inventory.get(code.toUpperCase());
    }

    @Override
    public VendingItem purchaseVendingItem(VendingItem item) {
        money = money.subtract(item.getPrice());
        item.setStock(item.getStock() - 1);
        return vendingItem;
    }

    @Override
    public void addMoney(BigDecimal newMoney) {
        money = money.add(newMoney);
    }

    @Override
    public String getBalanceString() {
        return money.toString();
    }

    @Override
    public BigDecimal getBalance() {
        return money;
    }

    @Override
    public HashMap<String, VendingItem> getInventory() {
        return inventory;
    }

    @Override
    public void loadInventory() throws VendingMachinePersistenceException {
    }

    @Override
    public void writeInventory() throws VendingMachinePersistenceException {
    }
    
}
