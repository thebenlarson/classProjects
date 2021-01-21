/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.doggenetics;
import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author benth
 */
public class DogGenetics {
    
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        
        String name;
        int usedPercent = 100;
        String breeds[] = {"dog_1", "dog_2", "dog_3", "dog_4", "dog_5"};
        
        System.out.println("What is your dogs name?");
        name = myScanner.next();
        
        int[] percentsArray = getPercents();
        
        for (int i = 0; i < 5; i++){
            System.out.println(percentsArray[i] + "% " + breeds[i]);
        }
        
    }
    
    public static int[] getPercents(){
        int myInts[] = new int[5];
        int total = 100;
        Random myRandom = new Random();
        for (int i = 0; i <4; i ++){
            int x = myRandom.nextInt(24) + 1;
            myInts[i] = x;
            total -= x;
        }
        myInts[4] = total;
        
        return myInts;
    }
}
