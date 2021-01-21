/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.yourlifeinmovies;

import java.util.Scanner;

/**
 *
 * @author benth
 */
public class YourLifeInMovies {
    public static void main(String[] args){
        int age;
        
        Scanner myScanner = new Scanner(System.in);
        
        System.out.println("Year? : ");
        age = Integer.parseInt(myScanner.nextLine());
        
        if (age < 2005){
            System.out.println("Pixar's 'Up' came out half a decade ago");
        } if (age < 1995){
            System.out.println("the first Harry Potter came out over 15 years ago");
        } if (age < 1985){
            System.out.println("Space Jam came out not last decade, but the one before THAT");
        } if (age < 1975){
            System.out.println("the original Jurassic Park release is closer to the date of the first lunar landing than it is to today.");
        } if (age < 1965){
            System.out.println("the MASH TV series has been around for almost half a century!");
        }
    }
}
