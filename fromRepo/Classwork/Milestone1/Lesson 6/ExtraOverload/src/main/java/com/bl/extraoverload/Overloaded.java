/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.extraoverload;

/**
 *
 * @author benth
 */
public class Overloaded {
    public void print(String myString){
        System.out.println(myString);
    }
    
    public void print(int myString){
        System.out.println(myString);
    }
    
    public void print(boolean myString){
        System.out.println(myString);
    }
    
    public void print(String myString, int myInt){
        System.out.println(myString);
    }
    public void print(int myInt, String myString){
        System.out.println(myString);
    }
    
}
