/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.flooring.ui;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
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
    
    @Override
    public String readStringLong(String prompt, boolean acceptNull){
        String output = "";
        do{
            print(prompt);
            output = myScanner.nextLine();
        
        } while(output.equals("") && !acceptNull);
        return output;
    }
    
    @Override
    public String readStringLong(String prompt, List<String> approvedValues){
        String output = "";
        int counter = 0;
        do {
            if (counter != 0){
                print("FAILURE: Please enter one of the options");
            }
            counter ++;
            print(prompt);
            print("Options: " + listConcatenation(approvedValues));
            output = myScanner.nextLine().toUpperCase();
        } while (!approvedValues.contains(output));
        return output;
    }
    
    private String listConcatenation(List<String> list){
        String string = "";
        for (String s : list){
            string = string + s + ", ";
        }
        string = string.substring(0, string.length() - 2);
        return string;
    }
    
    @Override
    public BigDecimal readBigDecimal(String prompt, boolean isEditing){
        BigDecimal output = null;
        boolean hasError;
        do {
            hasError = false;
            print(prompt);
            try{
                output = new BigDecimal(myScanner.nextLine());
            }catch(Exception e){
                if (isEditing){
                    return output;
                }
                print("FAILURE: Please enter a number");
                hasError = true;
            }
        } while (hasError);
        
        return output;
    }
    
    @Override
    public LocalDate readLocalDate(String prompt){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
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
