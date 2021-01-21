/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.flooring.controller;

import com.bl.flooring.dao.FlooringPersistenceException;
import com.bl.flooring.dto.*;
import com.bl.flooring.service.FlooringNoOrderException;
import com.bl.flooring.service.FlooringService;
import com.bl.flooring.ui.FlooringView;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author benth
 */
public class FlooringController {
    
    private final String CONFIG_FILE = "config.txt";
    private final String DELIMITER = "::";
    private boolean isTraining;
    
    private FlooringView view;
    private FlooringService service;

    public FlooringController(FlooringView view, FlooringService service) {
        this.view = view;
        this.service = service;
    }
    
    
    public void run(){
        loadData();
        boolean exit = false;
        int choice;
        
        while (!exit){
            boolean invalidChoice;
            displayMenu();
            
            do  {
                invalidChoice = false;
                choice = getMenuSelection();
                
                switch(choice){
                    case 1:
                        displayByDate();
                        break;
                    case 2:
                        displayById();
                        break;
                    case 3:
                        addOrder();
                        break;
                    case 4:
                        editOrder();
                        break;
                    case 5:
                        removeOrder();
                        break;
                    case 6:
                        saveData();
                        break;
                    case 7:
                        exit = true;
                        break;
                    default:
                        invalidChoice = true;
                        break;
                }
            } while (invalidChoice);
        }
        saveData();
        
    }
    
    private void displayMenu(){
        view.displayMenu();
    }
    
    private int getMenuSelection(){
        return view.getMenuSelection();
    }
    
    private void addOrder(){
        view.addOrderBanner();
        Order dirtyOrder = new Order(-1);
        dirtyOrder = view.getOrderInfo(dirtyOrder, service.getStates(), service.getProducts());
        view.orderInfoBanner();
        view.displayOrderShort(dirtyOrder);
        if (view.verifyData().equalsIgnoreCase("N")){
            view.displayError("Order has been canceled");
            return;
        }
        service.composeOrder(dirtyOrder);
    }
    
    private void editOrder(){
        List<String> states = new ArrayList<>(service.getStates()) ;
        List<String> products = new ArrayList<>(service.getProducts());
        states.add("");
        products.add("");
        
        view.editOrderBanner();
        Order order = searchByIdHelper();
        Order dirtyOrder = view.getOrderInfo(order, states, products);
        service.composeOrder(dirtyOrder);
    }
    
    private Order searchByIdHelper(){
        boolean hasError;
        Order order = null;
        
        do {
            hasError = false;
            try {
                order = service.getOrder(view.getOrderId());
            } catch (FlooringNoOrderException e) {
                view.displayError(e.getMessage());
                hasError = true;
            }
        }while(hasError);
        
        return order;
    }
    
    private void removeOrder(){
        view.removeOrderBanner();
        Order order = searchByIdHelper();
        if (view.verifyRemove().equalsIgnoreCase("N")){
            view.displayError("Remove has been canceled");
            return;
        }
        service.removeOrder(order);
        view.removeSuccessBanner();
    }
    
    private void displayById(){
        view.searchByIDBanner();
        Order order = searchByIdHelper();
        view.displayOneOrder(order);
    }
    
    private void displayByDate(){
        LocalDate date = view.getOrderDate("Please enter a date in format yyyy-MM-dd: ");
        List<Order> orders = service.getOrdersByDate(date);
        view.displayOrderBanner();
        view.displayOrders(orders);
    }
        
    public void loadData(){
        try {
            loadConfig();
            service.loadData();
        } catch (Exception e) {
            view.displayError(e.getMessage());
        }
    }
    
    public void saveData(){
        if (isTraining){
            view.displayError("Cannot save data during training mode.");
            return;
        }
        
        try {
            saveConfig(service.saveData());
        } catch (Exception e) {
            view.displayError(e.getMessage());
        }
    }
    
    private void loadConfig() throws FlooringPersistenceException{
        Scanner scanner;

        try {
            // Create Scanner for reading the file
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(CONFIG_FILE)));
        } catch (FileNotFoundException e) {
            throw new FlooringPersistenceException(
                    "-_- Could not load config data into memory.", e);
        }
        String currentLine;
        
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            String[] tokens = currentLine.split(DELIMITER);
            if (tokens[0].equalsIgnoreCase("server")){
                //determine if training
                isTraining = tokens[1].equalsIgnoreCase("training");
            } else {
                service.setIndex(tokens[1]);
            }
        }

        scanner.close();
    }
    private void saveConfig(int index) throws FlooringPersistenceException{
        PrintWriter out;

       try {
           out = new PrintWriter(new FileWriter(CONFIG_FILE));
       } catch (IOException e) {
           throw new FlooringPersistenceException(
                   "Could not save config item data.", e);
       }
       
       String server = "production";
       if (isTraining)
           server = "training";
       
       out.println("server" + DELIMITER + server);
       out.println("index" + DELIMITER + index);
       out.flush();

       out.close();
    }
    
    
    
}
