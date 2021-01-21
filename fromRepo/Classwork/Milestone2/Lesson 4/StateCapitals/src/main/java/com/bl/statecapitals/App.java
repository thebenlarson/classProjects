/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.statecapitals;

import java.util.HashMap;

/**
 *
 * @author benth
 */
public class App {
    
    public static void main(String[] args) {
        StateCapitals myStateCapitals = new StateCapitals();
        myStateCapitals.loadMap();
        
        HashMap<String, String> myHash = myStateCapitals.getStatesAndCapitals();
        System.out.println("States: ");
        myStateCapitals.printHashMapKeys(myHash);
        System.out.println("\n");
        
        System.out.println("Capitals: ");
        myStateCapitals.printHashMapValues(myHash);
        System.out.println("\n");
        
        System.out.println("State/Capital Pairs: ");
        myStateCapitals.printHashMap(myHash);
        
    }
}
