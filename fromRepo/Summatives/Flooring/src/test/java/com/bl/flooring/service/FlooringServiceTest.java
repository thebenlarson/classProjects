/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.flooring.service;

import com.bl.flooring.dao.FlooringDao;
import com.bl.flooring.dao.FlooringDaoFileImpl;
import com.bl.flooring.dao.FlooringPersistenceException;
import com.bl.flooring.dto.Order;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
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
public class FlooringServiceTest {
    
    ApplicationContext ctx = 
        new ClassPathXmlApplicationContext("applicationContext.xml");
    FlooringService service = 
        ctx.getBean("serviceLayer", FlooringService.class);
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        
    }
    
    @AfterEach
    public void tearDown() {
    }

    
    /**
     * Test of setIndex method, of class FlooringService.
     */
    @Test
    public void testSetIndex() {
        assertEquals(service.getIndex(), 0);
        service.setIndex("1");
        assertEquals(service.getIndex(), 1);
        
    }

    /**
     * Test of composeOrder method, of class FlooringService.
     */
    @Test
    public void testComposeOrder() {
        Order dirty = new Order(-1);
        dirty.setName("bob");
        dirty.setState("OH");
        dirty.setArea(BigDecimal.ONE);
        dirty.setProductType("CARPET");
        Order clean = service.composeOrder(dirty);
        
        assertEquals(clean.getArea(), dirty.getArea());
        assertEquals(clean.getName(), dirty.getName());
        assertEquals(clean.getState(), dirty.getState());
        assertEquals(clean.getProductType(), dirty.getProductType());
        assertEquals(clean.getLaborCostPerSqFoot().toString(), "10.00");
        assertEquals(clean.getMaterialCostPerSqFoot().toString(), "10.00");
        assertEquals(clean.getLaborCost().toString(), "10.00");
        assertEquals(clean.getMaterialCost().toString(), "10.00");
        assertEquals(clean.getTaxRate().toString(), "0.1");
        assertEquals(clean.getTax().toString(), "2.00");
        assertEquals(clean.getTotal().toString(), "22.00");
    }

    /**
     * Test of getStates method, of class FlooringService.
     */
    @Test
    public void testGetStates() {
        assertEquals(service.getStates().size(), 1);
        assertEquals(service.getStates().get(0), "OH");
    }

    /**
     * Test of getProducts method, of class FlooringService.
     */
    @Test
    public void testGetProducts() {
        assertEquals(service.getProducts().size(), 1);
        assertEquals(service.getProducts().get(0), "TILE");
    }

    /**
     * Test of getOrder method, of class FlooringService.
     */
    @Test
    public void testGetOrder() throws Exception {
        Order dirty = new Order(-1);
        dirty.setName("bob");
        dirty.setState("OH");
        dirty.setArea(BigDecimal.ONE);
        dirty.setProductType("CARPET");
        
        service.composeOrder(dirty);
        
        Order o = service.getOrder(1);
        assertEquals(o.getId(), 1);
        assertEquals(o.getName(), "bob");
        assertEquals(o.getState(), "OH");
        assertEquals(o.getArea(), BigDecimal.ONE);
        assertEquals(o.getProductType(), "CARPET");
    }
    
    @Test
    public void testGetOrderThrows() throws Exception {
        try{
            service.getOrder(2);
            fail("Expected FlooringNoOrderException was not thrown");
        } catch(FlooringNoOrderException e){
            return;
        }
    }

    /**
     * Test of removeOrder method, of class FlooringService.
     */
    @Test
    public void testRemoveOrder() {
        Order dirty = new Order(1);
        dirty.setName("bob");
        dirty.setState("OH");
        dirty.setArea(BigDecimal.ONE);
        dirty.setProductType("CARPET");
        
        service.composeOrder(dirty);
        
        assertEquals(service.getAllOrders().size(), 1);
        service.removeOrder(dirty);
        assertEquals(service.getAllOrders().size(), 0);
        
    }

    /**
     * Test of getOrdersByDate method, of class FlooringService.
     */
    @Test
    public void testGetOrdersByDate() {
        Order dirty = new Order(1);
        dirty.setName("bob");
        dirty.setState("OH");
        dirty.setArea(BigDecimal.ONE);
        dirty.setProductType("CARPET");
        
        service.composeOrder(dirty);
        assertEquals(service.getOrdersByDate(LocalDate.now()).size(), 1);
        assertEquals(service.getOrdersByDate(LocalDate.of(2020, Month.MARCH, 7)).size(), 0);
    }

    
    
}
