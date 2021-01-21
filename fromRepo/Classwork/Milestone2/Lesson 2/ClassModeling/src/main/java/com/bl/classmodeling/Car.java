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
public class Car {
    private int vin;
    private int lotId;
    private int speed;

    public int getVin() {
        return vin;
    }

    public void setVin(int vin) {
        this.vin = vin;
    }

    public int getLotId() {
        return lotId;
    }

    public void setLotId(int lotId) {
        this.lotId = lotId;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
    
    public void accelerate(){
        this.speed++;
    }
    
    public void brakes(){
        this.speed--;
    }
    
    public Car(){
        
    }
    
    public Car(int vin, int lotId){
        this.vin = vin;
        this.lotId = lotId;
    }
}
