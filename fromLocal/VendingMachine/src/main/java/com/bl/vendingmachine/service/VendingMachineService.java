/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.vendingmachine.service;

import com.bl.vendingmachine.dto.VendingItem;
import com.bl.vendingmachine.dao.*;
import java.util.List;

/**
 *
 * @author benth
 */
public interface VendingMachineService {
    List<VendingItem> getInStockVendingItems();
    List<VendingItem> getAllVendingItems();
    void loadInventory() throws VendingMachinePersistenceException;
    void writeInventory() throws VendingMachinePersistenceException;
    void addMoney(String money);
    String getBalance();
    VendingItem purchaseVendingItem(String code) throws 
            VendingMachineInsufficientFundsException,
            VendingMachineNoItemInventoryException,
            VendingMachineInvalidCodeException,
            VendingMachinePersistenceException;
    void checkBalance() throws VendingMachineInsufficientFundsException;
    String getChange();
}
