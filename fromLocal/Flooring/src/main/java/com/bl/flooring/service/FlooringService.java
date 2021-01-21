/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.flooring.service;

import com.bl.flooring.dao.FlooringPersistenceException;
import com.bl.flooring.dto.Order;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 *
 * @author benth
 */
public interface FlooringService {
    void loadData() throws FlooringPersistenceException;
    
    int saveData() throws FlooringPersistenceException;
    
    void setIndex(String index);
    
    int getIndex();
    
    Order composeOrder(Order order);
    
    List<String> getStates();
    
    List<String> getProducts();
    
    Order getOrder(int id) throws FlooringNoOrderException;
    
    void removeOrder(Order order);
    
    List<Order> getOrdersByDate(LocalDate date);
    
    Map<Integer, Order> getAllOrders();
    
}
