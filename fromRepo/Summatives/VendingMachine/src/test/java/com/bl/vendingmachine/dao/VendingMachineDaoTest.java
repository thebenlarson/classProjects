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
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author benth
 */
public class VendingMachineDaoTest {
    
    VendingMachineDao dao = new VendingMachineDaoFileImpl();
    
    public VendingMachineDaoTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        dao.getInventory().clear();
        dao.addMoney(dao.getBalance().negate());
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getAllVendingItems method, of class VendingMachineDao.
     */
    @Test
    public void testGetAllVendingItems() {
        HashMap<String, VendingItem> inventory = dao.getInventory();
        assertEquals(inventory.size(), 0);
        
        VendingItem item = new VendingItem("A1");
        item.setName("snack");
        item.setPriceString("1.00");
        item.setStock(2);
        inventory.put(item.getCode(), item);
        
        assertEquals(dao.getAllVendingItems().size(), 1);
        assertEquals(dao.getAllVendingItems().get(0), item);
    }

    /**
     * Test of getInStockVendingItems method, of class VendingMachineDao.
     */
    @Test
    public void testGetInStockVendingItems() {
        HashMap<String, VendingItem> inventory = dao.getInventory();
        assertEquals(inventory.size(), 0);
        
        VendingItem item = new VendingItem("A1");
        item.setName("snack");
        item.setPriceString("1.00");
        item.setStock(2);
        inventory.put(item.getCode(), item);
        
        VendingItem item2 = new VendingItem("A2");
        item2.setName("snack2");
        item2.setPriceString("12.00");
        item2.setStock(0);
        inventory.put(item2.getCode(), item2);
        
        assertEquals(dao.getInStockVendingItems().size(), 1);
        assertEquals(dao.getInStockVendingItems().get(0), item);
    }

    /**
     * Test of getOneVendingItem method, of class VendingMachineDao.
     */
    @Test
    public void testGetOneVendingItem() throws Exception {
        HashMap<String, VendingItem> inventory = dao.getInventory();
        assertEquals(inventory.size(), 0);
        
        VendingItem item = new VendingItem("A1");
        item.setName("snack");
        item.setPriceString("1.00");
        item.setStock(2);
        inventory.put(item.getCode(), item);
        
        assertEquals(dao.getOneVendingItem(item.getCode()), item);
    }
    
    @Test
    public void testGetOneVendingItemInvalidCode() throws Exception {
        HashMap<String, VendingItem> inventory = dao.getInventory();
        assertEquals(inventory.size(), 0);
        
        VendingItem item = new VendingItem("A1");
        item.setName("snack");
        item.setPriceString("1.00");
        item.setStock(2);
        inventory.put(item.getCode(), item);
        
        assertEquals(dao.getOneVendingItem(item.getCode()), item);
        
        try{
            dao.getOneVendingItem("wdcwdxx");
            fail("Expected VendingMachineInvalidCodeException was not thrown");
        } catch(VendingMachineInvalidCodeException e){
            return;
        }
        
    }

    /**
     * Test of purchaseVendingItem method, of class VendingMachineDao.
     */
    @Test
    public void testPurchaseVendingItem() {
        HashMap<String, VendingItem> inventory = dao.getInventory();
        assertEquals(inventory.size(), 0);
        
        VendingItem item = new VendingItem("A1");
        item.setName("snack");
        item.setPriceString("1.00");
        item.setStock(2);
        inventory.put(item.getCode(), item);
        
        dao.addMoney(BigDecimal.TEN);
        
        VendingItem item2 = dao.purchaseVendingItem(item);
        assertEquals(item2, item);
        assertEquals(item2.getStock(), 1);
        assertEquals(dao.getBalanceString(), "9.00");
    }

    /**
     * Test of addMoney method, of class VendingMachineDao.
     */
    @Test
    public void testAddGetMoney() {
        assertEquals(dao.getBalance().setScale(0), BigDecimal.ZERO);
        dao.addMoney(BigDecimal.TEN);
        assertEquals(dao.getBalanceString(), "10.00");
    }

    @Test
    public void testGetInventory() {
        HashMap<String, VendingItem> inventory = dao.getInventory();
        assertEquals(inventory.size(), 0);
        
        VendingItem item = new VendingItem("A1");
        item.setName("snack");
        item.setPriceString("1.00");
        item.setStock(2);
        inventory.put(item.getCode(), item);
        assertEquals(inventory.size(), 1);
        
        inventory.clear();
        assertEquals(inventory.size(), 0);
    }
    
}
