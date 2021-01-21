/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.highroller;

/**
 *
 * @author benth
 */
import java.util.Random;
import java.util.Scanner;

public class HighRoller {

    public static void main(String[] args) {

        Random diceRoller = new Random();
        Scanner myScanner = new Scanner(System.in);
        int x;
        
        System.out.println("How many sides are on your dice?");
        x = Integer.parseInt(myScanner.nextLine());

        int rollResult = diceRoller.nextInt(x) + 1;

        System.out.println("TIME TO ROOOOOOLL THE DICE!");
        System.out.println("I rolled a " + rollResult);

        if (rollResult == 1) {
            System.out.println("You rolled a critical failure!");
        } else if (rollResult == x){
            System.out.println("You rolled a critical! Nice Job!");
        }
    }
}
