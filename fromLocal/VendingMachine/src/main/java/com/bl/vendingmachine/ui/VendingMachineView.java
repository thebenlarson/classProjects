/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.vendingmachine.ui;

import com.bl.vendingmachine.dto.*;
import java.util.InputMismatchException;
import java.util.List;

/**
 *
 * @author benth
 */
public class VendingMachineView {
    private UserIO io;
    
    public VendingMachineView(UserIO io){
        this.io = io;
    }
    
    public void displayVendingItem(VendingItem vendingItem){
        String extraTab = "";
        if (vendingItem.getName().length() < 8){
            extraTab = "\t";
        }
        io.print(vendingItem.getCode() + "\t"
                + vendingItem.getName() + '\t' + extraTab
                + vendingItem.getPriceString());
    }
    
    public void displayInventory(List<VendingItem> inventory, String balance){
        io.print("====================================");
        io.print("Balance: " + balance);
        inventory.forEach(i -> displayVendingItem(i));
        io.print("====================================");
    }
    
    public void displayException(Exception e){
        io.print(e.getMessage());
    }
    
    public int displayMenu() throws InputMismatchException {
        return io.readInt("Please Select an Option Below:" + 
                "\n" + "1) Add Money \t 2) Make Purchase \t 3) Exit"
        );
    }
    
    public void displayInvalidChoice(){
        io.print("Invalid Choice. Please try again");
    }
    
    public String getAddMoney(){
        return io.readStringLong("Enter Money Amount: ");
    }
    
    public void displayBalance(String balance){
        io.print("Balance: " + balance);
    }
    
    public void displayInputError(){
        io.print("Input is of incorrect type. Please Try Again.");
    }
    
    public String getCode(){
        return io.readString("Input Code: ");
    }
    
    public void getItem(VendingItem vendingItem){
        io.print("You get " + vendingItem.getName() + " from the vending machine");
    }
    
    public void displayChange(String change){
        io.print("====================================");
        io.print(change);
    }
}
