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
public class Airplane {
    private int latitude;
    private int longitude;
    private int fuel;
    private String color;
    private String destination;

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
    
    public void displayFuel(){
        System.out.println("You have " + this.fuel + "fuel left");
    }
    
    public Airplane(){
        
    }
    
    public Airplane(int latitude, int longitude){
        this.latitude = latitude;
        this.longitude = longitude;
    }
    
    public Airplane(String color, String destination){
        this.color = color;
        this.destination = destination;
    }
}
