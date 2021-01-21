/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.flooring.dao;

import com.bl.flooring.dto.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author benth
 */
public class FlooringDaoFileImpl implements FlooringDao {
    
    ArrayList<State> states = new ArrayList<>();
    HashMap<Integer, Order> orders = new HashMap<>();
    ArrayList<Product> products = new ArrayList<>();
    
    public static final String ORDERS_FILE = "orders.txt";
    public static final String STATE_TAX_FILE = "stateTax.txt";
    public static final String PRODUCTS_FILE = "products.txt";
    public static final String DELIMITER = "::";
    
    @Override
    public void loadData() throws FlooringPersistenceException{
        loadOrders();
        loadStateTax();
        loadProducts();
    }
    
    @Override
    public void saveData() throws FlooringPersistenceException{
        writeOrders();
    }
    
    @Override
    public ArrayList<State> getStates(){
        return states;
    }
    
    @Override
    public HashMap<Integer, Order> getOrders(){
        return orders;
    }
    
    @Override
    public ArrayList<Product> getProducts(){
        return products;
    }
    
    private Order unmarshallOrder(String orderAsText){
        String[] orderTokens = orderAsText.split(DELIMITER);
        
        int orderId = Integer.parseInt(orderTokens[0]);
        Order orderFromFile = new Order(orderId);
        
        orderFromFile.setName(orderTokens[1]);
        orderFromFile.setState(orderTokens[2]);
        orderFromFile.setTaxRate(new BigDecimal(orderTokens[3]));
        orderFromFile.setProductType(orderTokens[4]);
        orderFromFile.setArea(new BigDecimal(orderTokens[5]));
        orderFromFile.setMaterialCostPerSqFoot(new BigDecimal(orderTokens[6]));
        orderFromFile.setLaborCostPerSqFoot(new BigDecimal(orderTokens[7]));
        orderFromFile.setMaterialCost(new BigDecimal(orderTokens[8]));
        orderFromFile.setLaborCost(new BigDecimal(orderTokens[9]));
        orderFromFile.setTax(new BigDecimal(orderTokens[10]));
        orderFromFile.setTotal(new BigDecimal(orderTokens[11]));
        orderFromFile.setDate(LocalDate.parse(orderTokens[12]));

        return orderFromFile;
    }
    
    private void loadOrders() throws FlooringPersistenceException{
        try (Scanner scanner = initializeScanner(ORDERS_FILE)) {
            String currentLine;
            Order currentOrder;
            
            while (scanner.hasNextLine()) {
                currentLine = scanner.nextLine();
                currentOrder = unmarshallOrder(currentLine);
                orders.put(currentOrder.getId(), currentOrder);
            }
        }
    }
    
    private void loadStateTax() throws FlooringPersistenceException{
        try (Scanner scanner = initializeScanner(STATE_TAX_FILE)) {
            String currentLine;
            
            while (scanner.hasNextLine()) {
                currentLine = scanner.nextLine();
                String[] tokens = currentLine.split(DELIMITER);
                State state = new State(tokens[0].toUpperCase(), new BigDecimal(tokens[1]));
                states.add(state);
            }
        }
    }
    
    private Scanner initializeScanner(String fileName) throws FlooringPersistenceException{
        Scanner scanner;

        try {
            // Create Scanner for reading the file
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(fileName)));
        } catch (FileNotFoundException e) {
            throw new FlooringPersistenceException(
                    "-_- Could not load "+ fileName +" into memory.", e);
        }
        return scanner;
    }
    
    private void loadProducts() throws FlooringPersistenceException{
        try (Scanner scanner = initializeScanner(PRODUCTS_FILE)) {
            String currentLine;
            
            while (scanner.hasNextLine()) {
                currentLine = scanner.nextLine();
                String[] tokens = currentLine.split(DELIMITER);
                Product product = new Product(tokens[0].toUpperCase(), new BigDecimal(tokens[1]) , new BigDecimal(tokens[2]));
                products.add(product);
            }
        }
    }
    
    private void writeOrders() throws FlooringPersistenceException{
       PrintWriter out;

       try {
           out = new PrintWriter(new FileWriter(ORDERS_FILE));
       } catch (IOException e) {
           throw new FlooringPersistenceException(
                   "Could not save vending item data.", e);
       }

       String orderAsText;
       List<Order> ordersList = this.getOrders().values().stream().collect(Collectors.toList());
       for (Order currentOrder : ordersList) {
           orderAsText = marshallOrder(currentOrder);
           out.println(orderAsText);
           out.flush();
       }

       out.close();
    }
    
    private String marshallOrder(Order order){
        String orderAsText = order.getId() + DELIMITER;
        
        orderAsText += order.getName()+ DELIMITER;
        orderAsText += order.getState()+ DELIMITER;
        orderAsText += order.getTaxRate()+ DELIMITER;
        orderAsText += order.getProductType()+ DELIMITER;
        orderAsText += order.getArea()+ DELIMITER;
        orderAsText += order.getMaterialCostPerSqFoot()+ DELIMITER;
        orderAsText += order.getLaborCostPerSqFoot()+ DELIMITER;
        orderAsText += order.getMaterialCost()+ DELIMITER;
        orderAsText += order.getLaborCost()+ DELIMITER;
        orderAsText += order.getTax()+ DELIMITER;
        orderAsText += order.getTotal() + DELIMITER;
        orderAsText += order.getDate();
        
        return orderAsText;
    }
}
