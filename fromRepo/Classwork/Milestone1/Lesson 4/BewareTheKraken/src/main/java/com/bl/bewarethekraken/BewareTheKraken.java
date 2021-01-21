/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.bewarethekraken;
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author benth
 */
public class BewareTheKraken {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        Random myRandom = new Random();
        String ans, fish;

        System.out.println("Already, get those flippers and wetsuit on - we're going diving!");
        System.out.println("Here we goooOOooOooo.....! *SPLASH*");

        int depthDivedInFt = 0, num;

        // Turns out the ocean is only so deep, 36200 at the deepest survey,
        // so if we reach the bottom ... we should probably stop.
        while(depthDivedInFt < 36200){
            System.out.println("So far, we've swum " + depthDivedInFt + " feet");
            //Random fish
            num = myRandom.nextInt(3);
            if (num == 0){
                fish = "Baracuda";
            } else if(num == 1){
                fish = "Tuna";
            } else {
                fish = "Big Tuna";
            }
            System.out.println("Wow! that was a " + fish);
            //
            System.out.println("Do you want to leave? (y/n)");
            ans = myScanner.nextLine();
            if (ans.equals("y")){
                //leave
                break;
            }

            if(depthDivedInFt >= 20000){
                System.out.println("Uhhh, I think I see a Kraken, guys ....");
                System.out.println("TIME TO GO!");
                break;
            }

            // I can swim, really fast! 500ft at a time!
            depthDivedInFt += 1000;
        }
        System.out.println("");
        System.out.println("We ended up swimming " + depthDivedInFt + " feet down.");
        System.out.println("I bet we can do better next time!");
    }
}
/*
4. We will hit the break statement written in the if >=20000

*/