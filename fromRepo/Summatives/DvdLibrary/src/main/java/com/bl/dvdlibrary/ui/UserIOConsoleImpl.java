/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.dvdlibrary.ui;

import com.bl.dvdlibrary.dao.DvdLibraryDaoException;
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
    
    public void print(DvdLibraryDaoException ex){
        System.out.println(ex);
    }

    @Override
    public double readDouble(String prompt){
        print(prompt);
        double output = myScanner.nextDouble();
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
        print(prompt);
        float output = myScanner.nextFloat();
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
        print(prompt);
        int output = myScanner.nextInt();
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
        print(prompt);
        long output = myScanner.nextLong();
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
    
}
