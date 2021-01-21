/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.trivianight;
import java.util.Scanner;
/**
 *
 * @author benth
 */
public class TriviaNight {
    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);
        int a_1, a_2, a_3, a_4, correct;
        correct = 0;
        
        System.out.println("FIRST QUESTION!\n" +
"What is the Lowest Level Programming Language?");
        System.out.println("1) Source Code \t" +
"2) Assembly Language");
        System.out.println("3) C# \t" +
"4) Machine Code");
        System.out.println("Your Answer: ");
        
        a_1 = Integer.parseInt(myScanner.nextLine());
        if (a_1 == 4){
            correct++;
        }
        //
        System.out.println("SECOND QUESTION!\n" +
"Website Security CAPTCHA Forms Are Descended From the Work of?");
        System.out.println("1) Grace Hopper \t" +
"2) Alan Turing");
        System.out.println("3) Charles Babbage \t" +
"4) Larry Page");
        System.out.println("Your Answer: ");
        
        a_2 = Integer.parseInt(myScanner.nextLine());
        if (a_2 == 2){
            correct++;
        }
        //
        System.out.println("LAST QUESTION!\n" +
"Which of These Sci-Fi Ships Was Once Slated for a Full-Size Replica in Las Vegas?");
        System.out.println("1) Serenity \t" +
"2) The Battlestar Galactica");
        System.out.println("3) The USS Enterprise \t" +
"4) Millenium Falcon");
        System.out.println("Your Answer: ");
        
        a_3 = Integer.parseInt(myScanner.nextLine());
        if (a_3 == 3){
            correct++;
        }
        
        if (correct == 0 || correct == 3){
            System.out.println("BONUS QUESTION!\n" +
"Who is the QB for Green Bay Packers?");
        System.out.println("1) Tony Romo \t" +
"2) Aaron Rodgers");
        System.out.println("3) Erin Rodgers \t" +
"4) Brett Favre");
        System.out.println("Your Answer: ");
        
        a_4 = Integer.parseInt(myScanner.nextLine());
        if (a_4 == 2){
            correct++;
        }
        }
        
        System.out.println("You got " + correct + " correct!");
    }
}
