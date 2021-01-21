/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.rockpaperscissors;
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author benth
 */
public class RockPaperScissors {
    static int playerWins, compWins, ties;
    
    public void run() {
        boolean playAgain, err = false;
        
        int rounds, playerChoice, compChoice;
        Scanner myScanner = new Scanner(System.in);
        
        do {
            clearInts();
            System.out.println("How many rounds would you like to play?");
            rounds = myScanner.nextInt();
            
            //check for error
            if (rounds <0 || rounds > 10){
                err = true;
                break;
            }
            
            //play rounds of Rock-Paper-Scissors
            for (int i = 0; i < rounds; i++){
                System.out.println("Pick 1) Rock 2) Paper 3) Scissors: ");
                playerChoice = myScanner.nextInt();
                compChoice = getRandom();
                evaluateGame(playerChoice, compChoice);
            }
            
            displayScoreboard();
            System.out.println("Would you like to play again? (y/n)");
            
            if (myScanner.next().equals("y")){
                playAgain = true;
            } else {
                playAgain = false;
            }
        } while(playAgain);
        
        if (err){
            System.out.println("Fatal Error: enter in a number between 1 an 10.");
        } else {
            System.out.println("Thanks for playing!");
        }
    }
    
    public static int getRandom(){
        Random myRandom = new Random();
        int x = myRandom.nextInt(3) + 1;
        
        return x;
    }
    
    public static void evaluateGame(int player, int computer){
        //dif represents the round result.
        int dif = player - computer;
        
        switch (dif){
            case 0:
                ties++;
                System.out.println("Tie!");
                break;
            case 1:
            case -2:
                playerWins++;
                System.out.println("Player Wins.");
                break;
            case -1:
            case 2:
                compWins++;
                System.out.println("Computer Wins!!!!");
                break;
        }
    }
    
    public static void clearInts(){
        playerWins = 0;
        compWins = 0;
        ties = 0;
    }
    
    public static void displayScoreboard(){
        System.out.println("Player Wins: " + playerWins + ", Computer Wins: " + compWins + ", Ties: " + ties);
        
        if (playerWins == compWins){
            System.out.println("Y'all tie!");
        } else if (playerWins > compWins){
            System.out.println("You win.");
        } else {
            System.out.println("You Lose!");
        }
    }
}
