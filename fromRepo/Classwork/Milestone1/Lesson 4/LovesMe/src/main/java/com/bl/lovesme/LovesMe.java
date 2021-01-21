/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.lovesme;

/**
 *
 * @author benth
 */
public class LovesMe {
    public static void main(String[] args) {
        int i = 34;
        boolean bool = true;
        
        while (i > 0){
            bool = !bool;
            i--;
            if (bool){
                System.out.println("It loves me");
            }else {
                System.out.println("It loves me NOT");
            }
        }
        System.out.println("Hooray");
    }
}
