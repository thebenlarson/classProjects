/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.maybeitlovesme;
import java.util.Random;
/**
 *
 * @author benth
 */
public class MaybeItLovesMe {
    public static void main(String[] args) {
        Random myRandom = new Random();
        int i = myRandom.nextInt(76) + 14;
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
        if (bool){
            System.out.println("Hooray");
        } else {
            System.out.println("@$TY#*$ITJ@");
        }
        
    }
}
