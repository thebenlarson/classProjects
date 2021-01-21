/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.forbyfor;

/**
 *
 * @author benth
 */
public class ForByFor {
    public static void main(String[] args) {
        String exp;

        for (int i = 0; i < 3; i++) {
            System.out.print("|");

            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    exp = "*";
                    if (j == 1 && i == 1){
                        exp = "#";
                    } else if (j == 1){
                        exp = "$";
                    } else if (i == 1){
                        exp = "@";
                    }
                    System.out.print(exp);
                }
                System.out.print("|");
            }
            System.out.println("");
        }
    }
}
