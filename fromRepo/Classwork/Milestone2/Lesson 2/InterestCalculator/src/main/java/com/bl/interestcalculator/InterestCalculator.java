/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.interestcalculator;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;
/**
 *
 * @author benth
 */
public class InterestCalculator {
    public void run() {
        Scanner myScanner = new Scanner(System.in);
        int years;
        BigDecimal interestRate, initialPrincipal, currentBalance;
        BigDecimal divisor = new BigDecimal("400");
        
        System.out.println("What is the annual interest rate?");
        interestRate = new BigDecimal( myScanner.next());
        interestRate = interestRate.setScale(2, RoundingMode.UP);
        myScanner.nextLine();
        
        System.out.println("What is the principal?");
        initialPrincipal = new BigDecimal( myScanner.next());
        initialPrincipal = initialPrincipal.setScale(2, RoundingMode.UP);
        myScanner.nextLine();
        
        System.out.println("How many years?");
        years = myScanner.nextInt();
        
        currentBalance = initialPrincipal;
        for (int i = 1; i <= years; i++){
            BigDecimal balance = currentBalance;
            for (int j = 0; j < 4; j++){
                currentBalance = currentBalance.multiply(new BigDecimal("1").add(interestRate.divide(divisor, 2, RoundingMode.HALF_UP))).setScale(2, RoundingMode.UP);;
            }
            System.out.println("Year: " + i + ", Starting Principal: " + balance + ", Interest Amount: " + (currentBalance.subtract(balance)) + ", Ending Principal: " + currentBalance);
        }
    }
}
