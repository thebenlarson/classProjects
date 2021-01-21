/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.vendingmachine.ui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 *
 * @author benth
 */
public class UserIOConsoleImpl implements UserIO{
    Scanner myScanner = new Scanner(System.in);
    
    @Override
    public void print(String message){
        System.out.println(message);
    }
    
    @Override
    public void print(int message){
        System.out.println(message);
    }
    
    @Override
    public double readDouble(String prompt){
        boolean error;
        double output = 0;
        do {
            error = false;
            print(prompt);
            if (myScanner.hasNextDouble()){
                output = myScanner.nextDouble();
            } else {
                myScanner.nextLine();
                print("FAILURE: Please enter a double!");
                error = true;
            }
        
        } while (error);
        
        myScanner.nextLine();
        return output;
    }

    @Override
    public double readDouble(String prompt, double min, double max){
        double output;
        do {
            output = readDouble(prompt);
        } while (output < min || output > max);
        
        return output;
    }

    @Override
    public float readFloat(String prompt){
        boolean error;
        float output = 0;
        do {
            error = false;
            print(prompt);
            if (myScanner.hasNextFloat()){
                output = myScanner.nextFloat();
            } else {
                myScanner.nextLine();
                print("FAILURE: Please enter a float!");
                error = true;
            }
        
        } while (error);
        
        myScanner.nextLine();
        return output;
    }

    @Override
    public float readFloat(String prompt, float min, float max){
        float output;
        do {
            output = readFloat(prompt);
        } while (output < min || output > max);
        
        return output;
    }

    @Override
    public int readInt(String prompt){
        boolean error;
        int output = 0;
        do {
            error = false;
            print(prompt);
            if (myScanner.hasNextInt()){
                output = myScanner.nextInt();
            } else {
                myScanner.nextLine();
                print("FAILURE: Please enter an int!");
                error = true;
            }
        
        } while (error);
        
        myScanner.nextLine();
        return output;
    }

    @Override
    public int readInt(String prompt, int min, int max){
        int output;
        do {
            output = readInt(prompt);
        } while (output < min || output > max);
        
        return output;
    }

    @Override
    public long readLong(String prompt){
        boolean error;
        long output = 0;
        do {
            error = false;
            print(prompt);
            if (myScanner.hasNextLong()){
                output = myScanner.nextLong();
            } else {
                myScanner.nextLine();
                print("FAILURE: Please enter an int!");
                error = true;
            }
        
        } while (error);
        
        myScanner.nextLine();
        return output;
    }

    @Override
    public long readLong(String prompt, long min, long max){
        long output;
        do {
            output = readLong(prompt);
        } while (output < min || output > max);
        
        return output;
    }

    @Override
    public String readString(String prompt){
        print(prompt);
        String output = myScanner.next();
        myScanner.nextLine();
        return output;
    }
    
    @Override
    public String readStringLong(String prompt){
        print(prompt);
        return myScanner.nextLine();
    }
    
    public LocalDate readLocalDate(String prompt){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate date = LocalDate.EPOCH;
        boolean hasError;
        
        do {            
            hasError = false;
            String dateAsString = readStringLong(prompt);
            try {
                date = LocalDate.parse(dateAsString, formatter);
            } catch (DateTimeParseException e) {
                print("Could not parse the date. Please enter the date in the format: ");
                hasError = true;
            }
        } while (hasError);
        
        return date;
    }
    
}
