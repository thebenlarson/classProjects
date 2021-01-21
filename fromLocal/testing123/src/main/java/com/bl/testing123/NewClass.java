/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.testing123;

/**
 *
 * @author benth
 */
public class NewClass {
    
    public static void main(String[] args) {
        System.out.println(calc(5));
    }
    
    public static int calc(int x){
        if (x == 0)
            return 1;
        else 
            return x * calc(x-1);
    }
}
