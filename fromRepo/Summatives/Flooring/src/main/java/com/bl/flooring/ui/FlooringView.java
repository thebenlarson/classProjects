/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.flooring.ui;

import com.bl.flooring.dto.Order;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author benth
 */
public class FlooringView {
    private UserIO io;

    public FlooringView(UserIO io) {
        this.io = io;
    }
    
    public void displayMenu(){
        io.print("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        io.print("*  <<Flooring Program>>");
        io.print("* 1. Display Orders By Date");
        io.print("* 2. Display Order By ID");
        io.print("* 3. Add an Order");
        io.print("* 4. Edit an Order");
        io.print("* 5. Remove an Order");
        io.print("* 6. Save Current Work");
        io.print("* 7. Quit");
        io.print("* ");
        io.print("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
    }
    
    public int getMenuSelection(){
        return io.readInt("Please Select an option from above: ", 1, 7);
    }
    
    public void displayError(String prompt){
        io.print("=== ERROR ===");
        io.print(prompt);
    }
    
    public void addOrderBanner(){
        io.print("=== Add Order ===");
    }
    
    public void editOrderBanner(){
        io.print("=== Edit Order ===");
    }
    
    public void searchByIDBanner(){
        io.print("=== Search By ID ===");
    }
    
    public void searchByDateBanner(){
        io.print("=== Search By Date ===");
    }
    
    public void removeOrderBanner(){
        io.print("=== Remove Order ===");
    }
    
    public void removeSuccessBanner(){
        io.print("=== Remove Successful ===");
    }
    
    public void orderInfoBanner(){
        io.print("=== Order Info ===");
    }
    
    
    public void displayOrderBanner(){
        io.print( "=== Order(s) ===");
        io.print("Note: Data may be shortened for display. For exact data please lookup the order by ID.");
        io.print( "ID" + "\t"
                + "Date" + "\t" + "\t"
                + "Name" + "\t"
                + "State" + "\t"
                + "Product" + "\t"
                + "MatCost/sqft" + "\t"
                + "LabCost/sqft" + "\t"
                + "Area" + "\t"
                + "MatCost" + "\t"
                + "LabCost" + "\t"
                + "Tax Rate" + "\t"
                + "Tax" + "\t"
                + "Total"
        );
    }
    
    public Order getOrderInfo(Order dirtyOrder, List<String> states, List<String> products){
        //need to pass in the allowed states and products
        Order order = new Order(dirtyOrder.getId());
        boolean isEditing = true;
        if (dirtyOrder.getId() == -1){
            isEditing = false;
        }
        
        String name = io.readStringLong("Please Enter Last Name: (Current Value) " + dirtyOrder.getName(), isEditing);
        String state = io.readStringLong("Please Enter State: (Current Value) " + dirtyOrder.getState(), states);
        String product = io.readStringLong("Please Enter Product: (Current Value) " + dirtyOrder.getProductType(), products);
        BigDecimal area = io.readBigDecimal("Please Enter Area: (Current Value) " + dirtyOrder.getArea(), isEditing);
        
        if (name.equals("") ){
            name = dirtyOrder.getName();
        }
        if (state.equals("") ){
            state = dirtyOrder.getState();
        }
        if (product.equals("") ){
            product = dirtyOrder.getProductType();
        }
        if (area == null ){
            area = dirtyOrder.getArea();
        }
        
        order.setName(name);
        order.setState(state);
        order.setProductType(product);
        order.setArea(area);
        
        return order;
    }
    
    public String verifyData(){
        ArrayList<String> values = new ArrayList<>();
        values.add("Y");
        values.add("N");
        
        return io.readStringLong("Is the above data correct? (Y/N)", values);
    }
    
    public String verifyRemove(){
        ArrayList<String> values = new ArrayList<>();
        values.add("Y");
        values.add("N");
        
        return io.readStringLong("Are you sure you want to remove the order? (Y/N)", values);
    }
    
    public int getOrderId(){
        return io.readInt("Please Enter the Order ID");
    }
    
    public LocalDate getOrderDate(String prompt){
        return io.readLocalDate(prompt);
    }
    
    public void displayOrder(Order order){
        io.print( order.getId() + "\t"
                + order.getDate()+ "\t"
                + truncate(order.getName()) + "\t"
                + order.getState() + "\t"
                + order.getProductType()+ "\t"
                + order.getMaterialCostPerSqFoot()+ "\t" + "\t"
                + order.getLaborCostPerSqFoot()+ "\t" + "\t"
                + order.getArea() + "\t"
                + truncate(order.getMaterialCost())+ "\t"
                + truncate(order.getLaborCost())+ "\t"
                + order.getTaxRate()+ "\t" + "\t"
                + truncate(order.getTax())+ "\t"
                + truncate(order.getTotal())
        );
    }
    
    public void displayOneOrder(Order order){
        io.print( "=== Order(s) ===");
        io.print("ID: " + order.getId());
        io.print("Date: " + order.getDate());
        io.print("Name: " + order.getName());
        io.print("State: " + order.getState());
        io.print("Product: " + order.getProductType());
        io.print("Material Cost Per Sqft: " + order.getMaterialCostPerSqFoot());
        io.print("Labor Cost Per Sqft: " + order.getLaborCostPerSqFoot());
        io.print("Area: " + order.getArea());
        io.print("Material Cost: " + order.getMaterialCost());
        io.print("Labor Cost: " + order.getLaborCost());
        io.print("Tax Rate: " + order.getTaxRate());
        io.print("Tax: " + order.getTax());
        io.print("Total: " + order.getTotal());
    }
    
    public void displayOrderShort(Order order){
        io.print( "Name: " + order.getName());
        io.print( "State: " + order.getState());
        io.print( "Product: " + order.getProductType());
        io.print( "Area: " + order.getArea());
    }
    
    public void displayOrders(List<Order> orders){
        if (orders.size() <= 0){
            io.print("No Orders Found :(");
            return;
        }
        for (Order o : orders){
            displayOrder(o);
        }
    }
    
    private String truncate(BigDecimal number){
        BigDecimal million = new BigDecimal("1000000");
        BigDecimal thousand = new BigDecimal("1000");
        String value = number.toString();
        if (value.length() > 7){
            //shorten
            number = number.setScale(0, RoundingMode.FLOOR);
            if (number.divide(million).compareTo(BigDecimal.ONE) >= 0){
                value = number.divide(million).setScale(0, RoundingMode.FLOOR).toString() + "M";
            } else if (number.divide(thousand).compareTo(BigDecimal.ONE) >= 0){
                value = number.divide(thousand).setScale(0, RoundingMode.FLOOR).toString() + "K";
            }
        }
        
        return value;
    }
    
    private String truncate(String input){
        if (input.length() > 7){
            input = input.substring(0, 4) + "...";
        }
        
        return input;
    }
}
