/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.guessmebetter;
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author benth
 */
public class GuessMeBetter {
    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);
        Random myRandom = new Random();
        int x = myRandom.nextInt(201) - 100;
        int guess;
        
        System.out.println("Guess a number");
        guess = Integer.parseInt(myScanner.nextLine());
        
        if (guess == x){
            System.out.println("You win");
        } else{
            if (guess < x){
                System.out.println("Too low. Try again");
            } else {
                System.out.println("Too high. Try again");
            }
            guess = Integer.parseInt(myScanner.nextLine());
            if (guess == x){
                System.out.println("You win");
            } else{
                if (guess < x){
                    System.out.println("Too low. Sorry");
                } else {
                    System.out.println("Too high. Sorry");
                }
            }
        } 
    }
}
