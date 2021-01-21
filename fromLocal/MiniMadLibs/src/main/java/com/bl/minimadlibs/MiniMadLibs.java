/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.minimadlibs;
import java.util.Scanner;

/**
 *
 * @author benth
 */
public class MiniMadLibs {
    public static void main (String[] args){
        String noun_1, adj_1, noun_2, adj_2, noun_p1, noun_p2, noun_p3, verb_1, verb_2;
        int number;
        Scanner myScanner = new Scanner(System.in);
        
        System.out.println("I need a noun: ");
        noun_1 = myScanner.nextLine();
        System.out.println("Now an adjective: ");
        adj_1 = myScanner.nextLine();
        System.out.println("Another noun: ");
        noun_2 = myScanner.nextLine();
        System.out.println("And a number: ");
        number = Integer.parseInt(myScanner.nextLine());
        System.out.println("Another adjective: ");
        adj_2 = myScanner.nextLine();
        System.out.println("A plural noun: ");
        noun_p1 = myScanner.nextLine();
        System.out.println("Another one: ");
        noun_p2 = myScanner.nextLine();
        System.out.println("One more: ");
        noun_p3 = myScanner.nextLine();
        System.out.println("A verb (infinitive form) ");
        verb_1 = myScanner.nextLine();
        System.out.println("Same verb (past participle) ");
        verb_2 = myScanner.nextLine();
        
        System.out.println(noun_1 + ": the " + adj_1 + " frontier. These are the voyages of the starship " + noun_2 +". \n" +
"    Its " + number + "-year mission: to explore strange " + adj_2 + " " + noun_p1 + ", to seek out " + adj_2 + " " + noun_p2 + " and " + adj_2 + " " + noun_p3 + ", \n" +
"    to boldly " + verb_1 + " where no one has " + verb_2 + " before.");
    }
}
