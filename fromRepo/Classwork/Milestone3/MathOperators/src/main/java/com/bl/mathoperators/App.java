/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.mathoperators;

import java.util.Scanner;

/**
 *
 * @author benth
 */
public class App {
    public static void main(String[] args) {
        IntMath math = new IntMath();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter two integers seperated by space");
        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();
        scanner.nextLine();
        
        for(IntMath.MathOperator operator : IntMath.MathOperator.values()){
            System.out.println(operator + ": " + math.calculate(operator, n1, n2) );
        }
    }
}
