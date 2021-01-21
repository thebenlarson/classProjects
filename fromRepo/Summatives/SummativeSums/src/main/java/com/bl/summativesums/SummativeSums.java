/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.summativesums;

/**
 *
 * @author benth
 */
public class SummativeSums {
    


    public static void main(String[] args) {
        int[] arr_1 = { 1, 90, -33, -55, 67, -16, 28, -55, 15 };
        int[] arr_2 = { 999, -60, -77, 14, 160, 301 };
        int[] arr_3 = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 
            140, 150, 160, 170, 180, 190, 200, -99 };
        
        System.out.println("Array #1: " + sumArray(arr_1));
        System.out.println("Array #2: " + sumArray(arr_2));
        System.out.println("Array #3: " + sumArray(arr_3));
    }
    
    public static int sumArray(int[] array){
        int sum = 0;
        for (int i = 0; i < array.length; i++){
            sum += array[i];
        }
        
        return sum;
    }
}
