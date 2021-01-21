/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.flooring.service;

import com.bl.flooring.dao.FlooringDao;
import com.bl.flooring.dao.FlooringPersistenceException;
import com.bl.flooring.dto.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author benth
 */
public class FlooringServiceImpl implements FlooringService {
    private int index;
    private FlooringDao dao;

    public FlooringServiceImpl(FlooringDao dao) {
        this.dao = dao;
    }
    
    
    @Override
    public void loadData() throws FlooringPersistenceException {
        dao.loadData();
    }
    
    @Override
    public int saveData() throws FlooringPersistenceException {
        dao.saveData();
        return index;
    }
    
    @Override
    public void setIndex(String index){
        this.index = Integer.parseInt(index);
    }
    
    @Override
    public int getIndex(){
        return this.index;
    }
    
    @Override
    public List<String> getStates(){
        return dao.getStates().stream()
                .map(State::getStateName)
                .collect(Collectors.toList());
    }
    
    @Override
    public List<String> getProducts(){
        return dao.getProducts().stream()
                .map(Product::getProductName)
                .collect(Collectors.toList());
    }
    
    @Override
    public Order getOrder(int id) throws FlooringNoOrderException{
        Order order = dao.getOrders().get(id);
        if (order == null){
            throw new FlooringNoOrderException("Order not found. Please try again");
        }
        return order;
    }
    
    @Override
    public List<Order> getOrdersByDate(LocalDate date){
        return dao.getOrders().values()
                .stream()
                .filter(o -> o.getDate().equals(date))
                .collect(Collectors.toList());
    }
    
    @Override
    public Map<Integer, Order> getAllOrders(){
        return dao.getOrders();
    }
    
    @Override
    public Order composeOrder(Order dirtyOrder){
        //ideally we just compose order
        int orderIndex = dirtyOrder.getId();
        if (orderIndex == -1){
            orderIndex = ++index;
        }
        Order order = new Order(orderIndex);
        
        order.setName(dirtyOrder.getName());
        order.setState(dirtyOrder.getState());
        order.setProductType(dirtyOrder.getProductType());
        order.setArea(dirtyOrder.getArea());
        
        //Fill out fields with data from dao    
        order.setTaxRate(findState(order.getState()).getTaxRate());
        order.setMaterialCostPerSqFoot(findProduct(order.getProductType()).getMaterialCostBySqFoot());
        order.setLaborCostPerSqFoot(findProduct(order.getProductType()).getLaborCostBySqFoot());
        
        //need to calculate certain fields and then set them and add dirtyOrder
        order.setMaterialCost(
                order.getMaterialCostPerSqFoot()
                        .multiply(order.getArea())
        );
        order.setLaborCost(
                order.getLaborCostPerSqFoot()
                        .multiply(order.getArea())
        );
        order.setTax(order.getTaxRate()
                                .divide(BigDecimal.TEN).divide(BigDecimal.TEN)
                                .multiply(
                                        order.getLaborCost().add(order.getMaterialCost())
                                ).setScale(2, RoundingMode.HALF_UP)
        );
        order.setTotal(
                order.getLaborCost()
                        .add(order.getMaterialCost())
                        .add(order.getTax())
        );
        
        order.setDate(LocalDate.now());
        
        dao.getOrders().put(order.getId(), order);
        return order;
    }
    
    @Override
    public void removeOrder(Order order){
        dao.getOrders().remove(order.getId());
    }
    
    private State findState(String name){
        State state = null;
        for (State s : dao.getStates()){
            if (s.getStateName().equalsIgnoreCase(name)){
                state = s;
            }
        }
        return state;
    }
    
    private Product findProduct(String name){
        Product product = null;
        for (Product p : dao.getProducts()){
            if (p.getProductName().equalsIgnoreCase(name)){
                product = p;
            }
        }
        return product;
    }
}
