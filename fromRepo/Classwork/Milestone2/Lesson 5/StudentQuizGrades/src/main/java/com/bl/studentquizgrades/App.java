/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.studentquizgrades;

/**
 *
 * @author benth
 */
public class App {
    public static void main(String[] args) {
        StudentGrades gradebook = new StudentGrades();
        IOClass iO = new IOClass();
        int choice;
        
        do {
            //display menu;
            iO.print("Menu:  ");
            iO.print("0) Add Grade");
            iO.print("1) View Students");
            iO.print("2) Add Student");
            iO.print("3) Remove Student");
            iO.print("4) View Student's Scores");
            iO.print("5) View Student's Average");
            iO.print("6) See Class Average");
            iO.print("7) Exit");
            
            choice = iO.readInt("Your Choice: ");
            gradebook.processChoice(choice);
            
        
        } while(true);
    }
}
