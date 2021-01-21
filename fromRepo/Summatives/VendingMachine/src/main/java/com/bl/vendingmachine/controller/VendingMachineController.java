/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.vendingmachine.controller;

import com.bl.vendingmachine.dao.VendingMachineInvalidCodeException;
import com.bl.vendingmachine.dao.VendingMachinePersistenceException;
import com.bl.vendingmachine.dto.VendingItem;
import com.bl.vendingmachine.service.*;
import com.bl.vendingmachine.ui.*;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author benth
 */
public class VendingMachineController {
    VendingMachineService service;
    VendingMachineView view;
    Scanner scanner = new Scanner(System.in);
    
    public VendingMachineController(VendingMachineService service, VendingMachineView view){
        this.service = service;
        this.view = view;
    }
    
    public void run(){
        boolean exit = false;
        int choice;
        loadData();
        
        while (!exit){
            displayInventory();
            boolean invalidChoice;
            
            do  {
                invalidChoice = false;
                choice = getMenuChoice();
                
                switch(choice){
                    case 1:
                        addMoney();
                        break;
                    case 2:
                        makePurchase();
                        break;
                    case 3:
                        exit = true;
                        break;
                    default:
                        invalidChoice();
                        invalidChoice = true;
                        break;
                }
            } while (invalidChoice);
        }
        giveChange();
        saveData();
       
    }
    
    private void displayInventory(){
        List<VendingItem> inventory = service.getInStockVendingItems();
        view.displayInventory(inventory, service.getBalance());
    }
    
    private void loadData(){
        try {
            service.loadInventory();
        } catch (VendingMachinePersistenceException ex) {
            displayException(ex);
        }
    }
    
    private void saveData(){
        try {
            service.writeInventory();
        } catch (VendingMachinePersistenceException ex) {
            displayException(ex);
        }
    }
    
    private int getMenuChoice(){
        return view.displayMenu();
    }
    
    private void addMoney(){
        boolean error;
        do {
            error = false;
            try{
                service.addMoney(view.getAddMoney());
            } catch (NumberFormatException e){
                error = true;
                displayInputError();
            }
            
        } while (error);
    }
    
    private void makePurchase(){
        try{
            service.checkBalance();
            VendingItem vendingItem = service.purchaseVendingItem(view.getCode());
            view.getItem(vendingItem);
        } catch (VendingMachineInsufficientFundsException | VendingMachineNoItemInventoryException
                | VendingMachineInvalidCodeException | VendingMachinePersistenceException e){
            displayException(e);
        }
    }
    
    private void invalidChoice(){
        view.displayInvalidChoice();
    }
    
    private void displayException(Exception e){
        view.displayException(e);
    }
    
    private void displayInputError(){
        view.displayInputError();
    }
    
    private void giveChange(){
        view.displayChange(service.getChange());
    }
}
