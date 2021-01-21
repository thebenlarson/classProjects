/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.bestadderever;
import java.util.Scanner; 

/**
 *
 * @author benth
 */
public class BestAdderEver {
    public static void main(String[] args) {
        int number_1, number_2, number_3, sum;
        String s_1, s_2, s_3;
        number_1 = number_2 = number_3 = 1;
        
        Scanner myScanner = new Scanner(System.in);
        
        System.out.println("Enter the first number: ");
        s_1 = myScanner.nextLine();
        System.out.println("Enter the second number: ");
        s_2 = myScanner.nextLine();
        System.out.println("Enter the third number: ");
        s_3 = myScanner.nextLine();
        
        number_1 = Integer.parseInt(s_1);
        number_2 = Integer.parseInt(s_2);
        number_3 = Integer.parseInt(s_3);
        
        sum = number_1 + number_2 + number_3;
        
        
        System.out.println("first number : " + number_1 + ", second number : " + number_2 + ", third number : " + number_3);
        System.out.println("The sum of the three numbers is : " + sum);
        System.out.println("The sum of the three numbers is : " + sum);
    }
    //
}
