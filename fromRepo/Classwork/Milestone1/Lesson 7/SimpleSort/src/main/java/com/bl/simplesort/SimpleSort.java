/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.simplesort;

import java.util.Arrays;

/**
 *
 * @author benth
 */
public class SimpleSort {
    public static void main(String[] args) {
        int[] firstHalf = {3, 7, 9, 10, 16, 19, 20, 34, 55, 67, 88, 99};
        int[] secondHalf = {1, 4, 8, 11, 15, 18, 21, 44, 54, 79, 89, 100};

        int[] wholeNumbers = new int[24];
        
        sort(wholeNumbers, firstHalf, secondHalf);
        Arrays.sort(wholeNumbers);
        
        System.out.println("Here ya go - all nice and ordered: \n");
        
        for (int i = 0; i < wholeNumbers.length; i++){
            System.out.print(wholeNumbers[i] + " \t");
        }
    }
    
    public static void sort(int[] wholeNumbers, int[] first, int[] second){
        int wholeCount = 0;
        for(int i = 0; i < first.length; i++){
            wholeNumbers[wholeCount] =  first[i];
            wholeCount++;
        }
        
        for(int i = 0; i < second.length; i++){
            wholeNumbers[wholeCount] =  second[i];
            wholeCount++;
        }
    }
}
