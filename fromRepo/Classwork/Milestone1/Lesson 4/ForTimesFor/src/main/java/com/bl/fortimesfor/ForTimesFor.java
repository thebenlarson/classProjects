/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.fortimesfor;
import java.util.Scanner;
/**
 *
 * @author benth
 */
public class ForTimesFor {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int x, ans, correct = 0;
        int TABLE_MAX = 10;
        
        System.out.println("Enter a number: ");
        x = myScanner.nextInt();
        
        for (int i = 1; i <= TABLE_MAX; i++){
            System.out.println("What is " + i + " times " + x + " ?");
            ans = myScanner.nextInt();
            correct = checkAnswer(i, x, ans, correct);
        }
        
        System.out.println("You got " + correct + " correct!");
        if (findPercent(correct, TABLE_MAX) < 50){
            System.out.println("You need to study more");
        } else if (findPercent(correct, TABLE_MAX) > 90){
            System.out.println("Wow! You did great!");
        }
        
    }
    
    public static int checkAnswer(int i, int x, int ans, int correct){
        if (ans == i * x){
            correct++;
        }
        return correct;
    }
    
    public static int findPercent(int correct, int max){
        int percent = Math.round(100f * (float) correct / (float) max);
        return percent;
    }
}
