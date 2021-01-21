/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.birthstones;
import java.util.Scanner;

/**
 *
 * @author benth
 */
public class BirthStones {
    public static void main (String[] args){
        int num;
        String month, stone;
        Scanner myScanner = new Scanner(System.in);
        
        System.out.println("Enter integer of month: ");
        num = Integer.parseInt(myScanner.nextLine());
        
        switch (num){
            case 1:
                month = "January";
                stone = "Garnet";
                break;
            case 2:
                month = "February";
                stone = "Amethyst";
                break;
            case 3:
                month = "March";
                stone = "Aquamarine";
                break;
            case 4:
                month = "April";
                stone = "Diamond";
                break;
            case 5:
                month = "May";
                stone = "Emerald";
                break;
            case 6:
                month = "June";
                stone = "Pearl";
                break; 
            case 7:
                month = "July";
                stone = "Ruby";
                break;
            case 8:
                month = "August";
                stone = "Peridot";
                break;
            case 9:
                month = "September";
                stone = "Sapphire";
                break;
            case 10:
                month = "October";
                stone = "Opal";
                break;
            case 11:
                month = "November";
                stone = "Topaz";
                break;
            case 12:
                month = "December";
                stone = "Turquoise";
                break; 
            default:
                month = "error";
                stone = "error";
        }
        
        System.out.println("Your month is : " + month + ", and your stone is : " + stone);
    }
}
