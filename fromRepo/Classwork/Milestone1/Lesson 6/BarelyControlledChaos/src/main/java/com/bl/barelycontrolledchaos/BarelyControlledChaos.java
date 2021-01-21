/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.barelycontrolledchaos;
import java.util.Random;
/**
 *
 * @author benth
 */
public class BarelyControlledChaos {
    static Random myRandom = new Random();
    static int x;
    public static void main(String[] args) {

        String color = randomColor(); // call color method here 
        String animal = randomAnimal(); // call animal method again here 
        String colorAgain = randomColor(); // call color method again here 
        int weight = randomNumber(5, 200); // call number method, 
            // with a range between 5 - 200 
        // call number method, 
        int distance = randomNumber(10, 20);
            // with a range between 10 - 20 
        // call number method, 
        int number = randomNumber(10000, 20000);
            // with a range between 10000 - 20000 
        // call number method, 
        int time = randomNumber(2, 6);
            // with a range between 2 - 6            
    
        System.out.println("Once, when I was very small...");

        System.out.println("I was chased by a " + color + ", "
            + weight + "lb " + " miniature " + animal 
            + " for over " + distance + " miles!!");

        System.out.println("I had to hide in a field of over " 
            + number + " " + colorAgain + " poppies for nearly " 
            + time + " hours until it left me alone!");

        System.out.println("\nIt was QUITE the experience, " 
            + "let me tell you!");
    } 
    
    // ??? Method 1 ??? 
    public static String randomColor(){
        String color = "red";
        x = myRandom.nextInt(5);
        
        switch(x){
            case 0:
                color = "blue";
                break;
            case 1:
                color = "green";
                break;
            case 2:
                color = "yellow";
                break;
            case 3:
                color = "white";
                break;
            default:
                break;
        }
        
        return color;
    }
    
    public static String randomAnimal(){
        String color = "gorilla";
        x = myRandom.nextInt(5);
        
        switch(x){
            case 0:
                color = "hippo";
                break;
            case 1:
                color = "Harambe";
                break;
            case 2:
                color = "tiger";
                break;
            case 3:
                color = "bear";
                break;
            default:
                break;
        }
        
        return color;
    }
    
    public static int randomNumber(int min, int max){
        x = myRandom.nextInt(max - min + 1) + min;
        return x;
    }
    /*
    10, 15
    10, 11, 12, 13, 14, 15
    */
    // ??? Method 2 ??? 
    // ??? Method 3 ??? 
}
