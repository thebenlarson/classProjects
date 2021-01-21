/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.statecapitals2;
import java.util.Scanner;

/**
 *
 * @author benth
 */
public class App {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        StateCapitals myStateCapitals = new StateCapitals();
        myStateCapitals.loadMap();
        myStateCapitals.printHashMap(myStateCapitals.getStatesAndCapitals());
        System.out.println("");
        System.out.println("Please enter the lower limit for capital city population: ");
        
        myStateCapitals.printHashMap(myStateCapitals.getStatesAndCapitals(), myScanner.nextInt());
    }
}

