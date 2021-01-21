/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.luckysevens;
import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author benth
 */
public class LuckySevens {
    public void run(){
        Scanner myScanner = new Scanner(System.in);
        Random myRandom = new Random();
        int dollars, max = 0, rolls = 0, maxRolls = 0;
        
        
        System.out.println("How many dollars do you have?");
        dollars = myScanner.nextInt();
        
        do {
            int x = myRandom.nextInt(6) + 1;
            int y = myRandom.nextInt(6) + 1;
            rolls++;
            
            if (x + y == 7){
                dollars += 4;
                if (dollars > max){
                    max = dollars;
                    maxRolls = rolls;
                }
            } else {
                dollars--;
            }
        } while (dollars > 0);
        
        System.out.println("You are broke after " + rolls + " rolls");
        System.out.println("Should have stopped at " + maxRolls + " when you had $" + max);
        
    }
}
