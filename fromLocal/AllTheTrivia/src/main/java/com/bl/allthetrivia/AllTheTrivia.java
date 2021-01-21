/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.allthetrivia;

import java.util.Scanner;

/**
 *
 * @author benth
 */
public class AllTheTrivia {
    public static void main (String[] args){
        Scanner myScanner = new Scanner(System.in);
        String gigabyte, mars, venus, gas;
        
        System.out.println("1,024 Gigabytes is equal to one what?");
        gigabyte = myScanner.nextLine();
        System.out.println("In our Solar System, which is the only planet that rotates clockwise?");
        venus = myScanner.nextLine();
        System.out.println("The largest volcano ever discovered in our Solar System is located on which planet?");
        mars = myScanner.nextLine();
        System.out.println("What is the most abundant element in the earth's atmosphere?");
        gas = myScanner.nextLine();
        
        System.out.println("Wow!! So 1,024 Gigabytes is equal to one " + mars + "! And The largest volcano ever discovered in our Solar System is located on " + gas + ". In our Solar System, the only planet that rotates clockwise is " + gigabyte + ". The most abundant element in the earth's atmosphere is " + venus + ". Truly Amazing, who knew?");
    }
}
