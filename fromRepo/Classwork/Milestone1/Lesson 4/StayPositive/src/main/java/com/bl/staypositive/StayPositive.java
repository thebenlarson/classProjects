/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.staypositive;
import java.util.Scanner;
/**
 *
 * @author benth
 */
public class StayPositive {
    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);
        int x, i = 0;
        
        System.out.println("Enter a number: ");
        x = Integer.parseInt(myScanner.nextLine());
        
        while ( x >= 0 ){
            System.out.print(x + "\t");
            if (i % 10 == 9){
                System.out.print("\n");
            }
            x--;
            i++;
        }
    }
}
