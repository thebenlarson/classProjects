/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.thecount;
import java.util.Scanner;

/**
 *
 * @author benth
 */
public class TheCount {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        
        int start, end, dif, count = 1;
        System.out.println("Enter start number: ");
        start = myScanner.nextInt();
        
        System.out.println("Enter end number: ");
        end = myScanner.nextInt();
        
        System.out.println("Enter iterator: ");
        dif = myScanner.nextInt();
        
        for (int i = start; i <= end; i += dif){
            System.out.print(i + "\t");
            
            if (count % 3 == 0){
                System.out.println(" - Ah ah ah!");
            }
            count++;
        }
    }
}
