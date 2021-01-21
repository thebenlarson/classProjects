/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.factorizer;

import java.util.Scanner;

/**
 *
 * @author benth
 */
public class FactorizerLogic {
    public void run(){
        Scanner myScanner = new Scanner(System.in);
        int factorCount = 0;
        int factorSum = 0;
        
        System.out.println("Enter a number to factor: ");
        int x = myScanner.nextInt();
        System.out.println("The factors of " + x + " are: ");
        
        for (int i = 1; i < x; i++){
            if (x % i == 0){
                //found a factor
                System.out.println(i);
                factorCount++;
                factorSum += i;
            }
        }
        
        if(factorSum == x){
            System.out.println(x + " is a perfect number.");
        } else {
            System.out.println(x + " is a Not perfect number.");
        }
        
        if(factorCount > 1){
            System.out.println(x + " is Not a prime number.");
        } else {
            System.out.println(x + " is a prime number.");
        }
        
    }
}
