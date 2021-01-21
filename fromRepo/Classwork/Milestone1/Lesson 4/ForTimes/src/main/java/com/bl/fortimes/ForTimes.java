/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.fortimes;
import java.util.Scanner;
/**
 *
 * @author benth
 */
public class ForTimes {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int x;
        
        System.out.println("Enter a number: ");
        x = myScanner.nextInt();
        
        for (int i = 1; i < 16; i++){
            System.out.println(i + " times " + x + " is " + i * x);
        }
    }
}
