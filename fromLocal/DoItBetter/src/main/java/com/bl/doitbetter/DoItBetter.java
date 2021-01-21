/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.doitbetter;
import java.util.Scanner;
/**
 *
 * @author benth
 */
public class DoItBetter {
    public static void main (String[] args){
        Scanner myScanner = new Scanner(System.in);
        int miles, hotdogs, languages;
        
        System.out.println("Nice to meet you. How many miles can you jog?");
        miles = Integer.parseInt(myScanner.nextLine());
        System.out.println("Oh wow, thats really good! I can do " + (miles * 2 + 1) + ". How many hotdogs can you eat?");
        hotdogs = Integer.parseInt(myScanner.nextLine());
        System.out.println("Wow, I remember one time I ate " + (hotdogs * 2 + 1) + ". How many languages can you speak?");
        languages = Integer.parseInt(myScanner.nextLine());
        System.out.println("Haha. I can speak " + (languages * 2 + 1) );
        
    }
}
