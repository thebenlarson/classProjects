/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.friday;

import java.util.Scanner;

/**
 *
 * @author benth
 */
public class Controller {
    Scanner scanner = new Scanner(System.in);
    
    public enum Weekday {
        MONDAY("monday"), TUESDAY("tuesday"), WEDNESDAY("wednesday"), THURSDAY("thursday"), FRIDAY("friday"), SATURDAY("saturday"), SUNDAY("sunday");
        
        private String text;

        Weekday(String text) {
            this.text = text;
        }

        public String getText() {
            return this.text;
        }

        public static Weekday fromString(String text) {
            for (Weekday b : Weekday.values()) {
                if (b.text.equalsIgnoreCase(text)) {
                    return b;
                }
            }
            return null;
        }
    }
    
    private Weekday askForDay(){
        System.out.println("Please enter a day: ");
        String day = scanner.nextLine();
        return Weekday.fromString(day);
    }
    
    public void run(){
        
        Weekday day = null;
        while (day == null){
            day = askForDay();
        }
        int daysLeft = 0;
        
        switch(day){
            case MONDAY:
                daysLeft = 4;
                break;
            case TUESDAY:
                daysLeft = 3;
                break;
            case WEDNESDAY:
                daysLeft = 2;
                break;
            case THURSDAY:
                daysLeft = 1;
                break;
            case FRIDAY:
                daysLeft = 0;
                break;
            case SATURDAY:
                daysLeft = 6;
                break;
            case SUNDAY:
                daysLeft = 5;
                break;
            default:
                System.out.println("Spell better. Try again.");
                System.exit(0);
        }
        
        System.out.println(daysLeft + " many days left until Friday!");
    }
}
