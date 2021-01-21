/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.guessmefinally;
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author benth
 */
public class GuessMeFinally {
    public static void main(String[] args){
        int number, guess, i = 0;
        
        Scanner myScanner = new Scanner(System.in);
        Random myRandom = new Random();
        number = myRandom.nextInt(201) - 100;
        
        
        System.out.println("I chose a number between -100 and 100. Guess: ");
        guess = Integer.parseInt(myScanner.nextLine());
        
        while (guess != number) {
            if (guess < number){
                System.out.println("Too low. ");
            } else {
                System.out.println("Too high. ");
            }
            System.out.println("Guess again: ");
            guess = Integer.parseInt(myScanner.nextLine());
            i++;
        }
        
        if (i == 0){
            System.out.println("Wow you got it first try!");
        }else {
            System.out.println("Took you " + i + " tries. Get better.");
        }
    }
}
