/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.vendingmachine.service;

import com.bl.vendingmachine.dao.*;
import com.bl.vendingmachine.dto.VendingItem;
import java.math.BigDecimal;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author benth
 */
public class VendingMachineServiceTest {
    ApplicationContext ctx = 
        new ClassPathXmlApplicationContext("applicationContext.xml");
    VendingMachineService service = 
        ctx.getBean("serviceLayer", VendingMachineService.class);
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        BigDecimal negative = new BigDecimal(service.getBalance()).negate();
        service.addMoney(negative.toString());
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getInStockVendingItems method, of class VendingMachineService.
     */
    @Test
    public void testGetInStockVendingItems() {
        assertEquals(service.getInStockVendingItems().size(), 1);
    }

    /**
     * Test of getAllVendingItems method, of class VendingMachineService.
     */
    @Test
    public void testGetAllVendingItems() {
        assertEquals(service.getAllVendingItems().size(), 2);
    }
    
    /**
     * Test of addMoney method, of class VendingMachineService.
     */
    @Test
    public void testAddMoneyGetBalance() {
        assertEquals(service.getBalance(), "0.00");
        service.addMoney("1.00");
        assertEquals(service.getBalance(), "1.00");
    }

    /**
     * Test of purchaseVendingItem method, of class VendingMachineService.
     */
    @Test
    public void testPurchaseVendingItem() throws Exception {
        service.addMoney("1.00");
        try {
            VendingItem item = service.purchaseVendingItem("A1");
            assertEquals(item.getCode(), "A1");
        } catch( VendingMachineInsufficientFundsException | VendingMachineInvalidCodeException
                | VendingMachineNoItemInventoryException | VendingMachinePersistenceException e){
            fail("Failed Test: Expected to purchase an item");
        }
    }
    
    @Test
    public void testPurchaseVendingItemFunds() throws Exception {
        try {
            VendingItem item = service.purchaseVendingItem("A1");
            fail("Failed Test: Expected VendingMachineInsufficientFundsException");
        } catch( VendingMachineInsufficientFundsException e){
            return;
        }
    }
    
    @Test
    public void testPurchaseVendingItemCode() throws Exception {
        service.addMoney("1.00");
        try {
            VendingItem item = service.purchaseVendingItem("A3");
            fail("Failed Test: Expected VendingMachineInvalidCodeException");

        } catch( VendingMachineInvalidCodeException e){
            return;
        }
    }
    
    @Test
    public void testPurchaseVendingItemStock() throws Exception {
        service.addMoney("1.00");
        try {
            VendingItem item = service.purchaseVendingItem("A2");
            fail("Failed Test: Expected VendingMachineNoItemInventoryException");

        } catch( VendingMachineNoItemInventoryException e){
            return;
        }
    }

    /**
     * Test of checkBalance method, of class VendingMachineService.
     */
    @Test
    public void testCheckBalance() throws Exception {
        service.addMoney("1.00");
        try {
            service.checkBalance();
        } catch( VendingMachineInsufficientFundsException e){
            fail("Failed Test: Expected to have money in balance");
        }
    }
    
    @Test
    public void testCheckBalanceFunds() throws Exception {
        assertEquals(service.getBalance(), "0.00");
        try {
            service.checkBalance();
            fail("Failed Test: VendingMachineInsufficientFundsException expected");
        } catch( VendingMachineInsufficientFundsException e){
            return;
        }
    }

    /**
     * Test of getChange method, of class VendingMachineService.
     */
    @Test
    public void testGetChange() {
        service.addMoney("1.00");
        String change = "Returns $1.00 as 4 QUARTERS, 0 DIMES, 0 NICKELS, 0 PENNIES.";
        assertEquals(service.getChange(), change);
    }
    
}
