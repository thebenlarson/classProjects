/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.fieldday;

import java.util.Scanner;

/**
 *
 * @author benth
 */
public class FieldDay {
    public static void main (String[] args){
        String name, team;
        int var1;
        Scanner myScanner = new Scanner(System.in);
        
        System.out.println("Enter name: ");
        name = myScanner.nextLine();
        
        var1 = name.compareToIgnoreCase("Baggains");
        System.out.println(var1);
        if (name.compareToIgnoreCase("Baggains") < 0){
            team = "Red Dragons";
        } else if (name.compareToIgnoreCase("Dresden") < 0){
            team = "Dark Wizards";
        } else if (name.compareToIgnoreCase("Howl") < 0){
            team = "Moving Castles";
        } else if (name.compareToIgnoreCase("Potter") < 0){
            team = "Golden Snitches";
        } else if (name.compareToIgnoreCase("Vimes") < 0){
            team = "Night Guards";
        } else {
            team = "Black Holes";
        }
        
        
        System.out.println("You're on the team " + team);
    }
}
