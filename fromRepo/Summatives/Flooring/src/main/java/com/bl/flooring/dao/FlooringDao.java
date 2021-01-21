/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.flooring.dao;

import com.bl.flooring.dto.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author benth
 */
public interface FlooringDao {
    public void loadData() throws FlooringPersistenceException;
    
    public void saveData() throws FlooringPersistenceException;
    
    public ArrayList<State> getStates();
    
    public HashMap<Integer, Order> getOrders();
    
    public ArrayList<Product> getProducts();
}
