/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.healthyhearts;
import java.util.Scanner;

/**
 *
 * @author benth
 */
public class HealthyHearts {
    public static void main (String[] args){
        Scanner myScanner = new Scanner(System.in);
        int age, maxHeartRate;
        float heartMin, heartMax;
        
        System.out.println("How old are you?");
        age = Integer.parseInt(myScanner.nextLine());
        
        maxHeartRate = 220 - age;
        heartMin = .5f * maxHeartRate;
        heartMax = .85f * maxHeartRate;
        
        System.out.println("Your max heart rate is " + maxHeartRate);
        System.out.println("Your target heart rate zone is from " + heartMin + " to " + heartMax);
    }
}
