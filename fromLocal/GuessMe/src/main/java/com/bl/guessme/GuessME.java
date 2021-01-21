/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.guessme;

import java.util.Scanner;

/**
 *
 * @author benth
 */
public class GuessME {
    public static void main(String[] args){
        int number, guess;
        number = 4;
        
        Scanner myScanner = new Scanner(System.in);
        
        System.out.println("Guess a number: ");
        guess = Integer.parseInt(myScanner.nextLine());
        
        if (guess == number){
            System.out.println("Wow you got it!!");
        } else if (guess < number){
            System.out.println("Too low :/");
        } else {
            System.out.println("Too high");
        }
    }
}
