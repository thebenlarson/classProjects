package com.bl.traditionalfizzbuzz;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;
/**
 *
 * @author benth
 */
public class TraditionalFizzBuzz {
    public static void main(String[] args) {
        int stopper, j = 0;
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        stopper = myScanner.nextInt();
        for (int i = 0; i <= stopper * 3; i++){
            if (i % 5 == 0 && i % 3 == 0  && i != 0){
                System.out.println("fizzbuzz");
                j++;
            } else if (i % 5 == 0 && i != 0){
                System.out.println("buzz");
                j++;
            } else if (i % 3 == 0 && i != 0){
                System.out.println("fizz");
                j++;
            } else {
                System.out.println(i);
            }
            
            if (j >= stopper){
                System.out.println("TRADITION!!!!");
                break;
            }
        }
    }
}


/*
# 1 2 3 4
@ 3 6 9 12
3 1 2 3 4
5 0 1 1 2
L 3 5 8

3*# - Floor(3*#/5) - spits out the last number

*/