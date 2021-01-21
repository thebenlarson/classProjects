/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.lazyteenager;

import java.util.Random;

/**
 *
 * @author benth
 */
public class LazyTeenager {
    public static void main(String[] args) {
        Random myRandom = new Random();
        int i = 1, cleanChance;
        boolean cleaning = false;
        
        do{
            if (i >= 15){
                System.out.println("Thats it. Your Grounded!");
                break;
            }
            System.out.println("Clean your Room!");
            cleanChance = myRandom.nextInt(20);
            if (cleanChance <= i){
                cleaning = true;
            }
            i++;
        } while (!cleaning);
        
        if (cleaning){
            System.out.println("FINE! I'LL CLEAN MY ROOM. BUT I REFUSE TO EAT MY PEAS.");
        }
    }
}
