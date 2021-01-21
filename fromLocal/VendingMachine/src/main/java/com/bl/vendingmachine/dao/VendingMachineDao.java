/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.vendingmachine.dao;

import com.bl.vendingmachine.dto.VendingItem;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author benth
 */
public interface VendingMachineDao {
    List<VendingItem> getAllVendingItems();
    
    List<VendingItem> getInStockVendingItems();
    
    VendingItem getOneVendingItem(String code) throws  VendingMachineInvalidCodeException;
    
    VendingItem purchaseVendingItem(VendingItem item);    
    
    void addMoney(BigDecimal newMoney);
    
    String getBalanceString();
    
    BigDecimal getBalance();
    
    HashMap<String, VendingItem> getInventory();
    
    void loadInventory() throws VendingMachinePersistenceException;
    
    void writeInventory() throws VendingMachinePersistenceException;
}
