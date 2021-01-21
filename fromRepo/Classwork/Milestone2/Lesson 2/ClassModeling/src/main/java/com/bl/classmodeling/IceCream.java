/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.classmodeling;

/**
 *
 * @author benth
 */
public class IceCream {
    public String flavor;
    public int shelfId;
    public int price;
    public String location;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public int getShelfId() {
        return shelfId;
    }

    public void setShelfId(int shelfId) {
        this.shelfId = shelfId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public IceCream(String flavor, int shelfId, int price) {
        this.flavor = flavor;
        this.shelfId = shelfId;
        this.price = price;
    }
    
    public int calculateTax(){
        return price * 2;
    }
}
