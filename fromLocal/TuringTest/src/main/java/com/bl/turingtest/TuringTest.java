/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.turingtest;

import java.util.Scanner;
/**
 *
 * @author benth
 */
public class TuringTest {
    public static void main (String[] args){
        String name, color, food, number;
        Scanner myScanner = new Scanner(System.in);
        
        System.out.println("Hello, what is your name?");
        name = myScanner.nextLine();
        System.out.println("Thats a nice name, " + name + ". I am cybertron");
        System.out.println("What is your favorite food?");
        food = myScanner.nextLine();
        System.out.println("What is your favorite color?");
        color = myScanner.nextLine();
        System.out.println("What is your favorite number?");
        number = myScanner.nextLine();
        
        System.out.println("I have to go. It was nice meeting you " + name + ", who likes the number " + number + ", and the color " + color + " and the food " + food);
    }
}
