/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.flooring.service;

import com.bl.flooring.dao.FlooringPersistenceException;
import com.bl.flooring.dto.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author benth
 */
public class FlooringServiceStubImpl implements FlooringService{
    
    private int index;
    HashMap<Integer, Order> orders = new HashMap<>();

    @Override
    public void loadData() throws FlooringPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int saveData() throws FlooringPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setIndex(String index) {
        this.index = Integer.parseInt(index);
    }

    @Override
    public int getIndex() {
        return index;
    }

    @Override
    public Order composeOrder(Order order) {
        Order newOrder = new Order(1);
        newOrder.setArea(order.getArea());
        newOrder.setDate(LocalDate.now());
        newOrder.setName(order.getName());
        newOrder.setProductType(order.getProductType());
        newOrder.setState(order.getState());
        newOrder.setTaxRate(BigDecimal.ONE.divide(BigDecimal.TEN));
        newOrder.setMaterialCostPerSqFoot(new BigDecimal("10.00"));
        newOrder.setLaborCostPerSqFoot(new BigDecimal("10.00"));
        newOrder.setMaterialCost(newOrder.getArea().multiply(newOrder.getMaterialCostPerSqFoot()));
        newOrder.setLaborCost(newOrder.getArea().multiply(newOrder.getLaborCostPerSqFoot()));
        newOrder.setTax((newOrder.getLaborCost().add(newOrder.getMaterialCost())).multiply(newOrder.getTaxRate()).setScale(2, RoundingMode.HALF_UP));
        newOrder.setTotal(newOrder.getLaborCost().add(newOrder.getMaterialCost()).add(newOrder.getTax()));
        orders.put(newOrder.getId(), newOrder);
        
        return newOrder;
    }

    @Override
    public List<String> getStates() {
        List<String> list = new ArrayList<>();
        String state = "OH";
        list.add(state);
        return list;
    }

    @Override
    public List<String> getProducts() {
        List<String> list = new ArrayList<>();
        String state = "TILE";
        list.add(state);
        return list;
    }

    @Override
    public Order getOrder(int id) throws FlooringNoOrderException {
        if (id != 1){
            throw new FlooringNoOrderException("Order not found");
        }
        
        Order order = orders.get(id);
        
        return order;
    }

    @Override
    public void removeOrder(Order order) {
        orders.remove(order.getId());
    }

    @Override
    public List<Order> getOrdersByDate(LocalDate date) {
        return orders.values().stream()
                .filter(o -> o.getDate().equals(date))
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, Order> getAllOrders() {
        return orders;
    }
    
}
