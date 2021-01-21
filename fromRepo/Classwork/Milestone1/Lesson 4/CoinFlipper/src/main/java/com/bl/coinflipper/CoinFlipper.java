/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.coinflipper;
import java.util.Random;
/**
 *
 * @author benth
 */
public class CoinFlipper {
    public static void main(String[] args){
        Random myRandom = new Random();
        boolean bool;
        
        bool = myRandom.nextBoolean();
        System.out.println("Ready, Set, Flip....!!");
        if (bool){
            System.out.println("You got HEADS!!!");
        } else {
            System.out.println("You got Tails!");
        }
    }
}
