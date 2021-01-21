/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.flooring.dao;

import com.bl.flooring.dto.Order;
import com.bl.flooring.dto.Product;
import com.bl.flooring.dto.State;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
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
public class FlooringDaoTest {
    
    FlooringDao dao = new FlooringDaoFileImpl();
    
    public FlooringDaoTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        dao.getOrders().clear();
        dao.getProducts().clear();
        dao.getStates().clear();
    }
    
    @AfterEach
    public void tearDown() {
    }
    
    /**
     * Test of getStates method, of class FlooringDao.
     */
    @Test
    public void testGetStates() {
        assertEquals(dao.getStates().size(), 0);
        State state = new State("HI", new BigDecimal(BigInteger.ONE));
        dao.getStates().add(state);
        assertEquals(dao.getStates().size(), 1);
    }

    /**
     * Test of getOrders method, of class FlooringDao.
     */
    @Test
    public void testGetOrders() {
        assertEquals(dao.getOrders().size(), 0);
        Order order = new Order(1);
        dao.getOrders().put(order.getId(), order);
        assertEquals(dao.getOrders().size(), 1);
    }

    /**
     * Test of getProducts method, of class FlooringDao.
     */
    @Test
    public void testGetProducts() {
        assertEquals(dao.getProducts().size(), 0);
        Product product = new Product("SAND", new BigDecimal(BigInteger.ONE), new BigDecimal(BigInteger.ONE));
        dao.getProducts().add(product);
        assertEquals(dao.getProducts().size(), 1);
    }
    
}
