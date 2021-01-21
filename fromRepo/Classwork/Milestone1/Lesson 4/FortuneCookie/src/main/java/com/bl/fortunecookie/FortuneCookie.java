/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.fortunecookie;
import java.util.Random;
/**
 *
 * @author benth
 */
public class FortuneCookie {
    public static void main(String[] args){
        Random myRandom = new Random();
        int x = myRandom.nextInt(10);
        String fortune;
        
        switch (x){
            case 0:
                fortune = "Those aren't the droids you're looking for.";
                break;
            case 1:
                fortune = "Never go in against a Sicilian when death is on the line!";
                break;
            case 2:
                fortune = "Goonies never say die.";
                break;
            case 3:
                fortune = "With great power there must also come great responsibility.";
                break;
            case 4:
                fortune = "Never argue with the data.";
                break;
            case 5:
                fortune = "Try not. Do, or do not. There is no try.";
                break;
            case 6:
                fortune = "You are a leaf on the wind, watch how you soar.";
                break;
            case 7:
                fortune = "Do absolutely nothing, and it will be everything that you thought it could be.";
                break;
            case 8:
                fortune = "Kneel before Zod.";
                break;
            default:
                fortune = "Make it so.";
                break;
        }
        
        System.out.println("Your Geek Fortune : " + fortune);
    }
}
