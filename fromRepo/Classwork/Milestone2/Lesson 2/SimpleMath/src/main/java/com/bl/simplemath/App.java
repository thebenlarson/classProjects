/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.simplemath;


import java.util.ArrayList;
import com.bl.userio.IOClass;

/**
 *
 * @author benth
 */
public class App { 
    static IOClass myIO = new IOClass();
    
    public enum Choice {
        ADD(1), SUBTRACT(2), MULTIPLY(3), DIVIDE(4);
        private final int value;

        private Choice(int value) {
                this.value = value;
        }
        
        public static Choice valueOfLabel(int value) {
            for (Choice e : values()) {
                if (e.value == value) {
                    return e;
                } else {
                }
            }
            return null;
        }
    }

    public static void main(String[] args) {
        
        
        while (true){
            int operation = chooseOperation();
        
            if (operation == 0){
                System.exit(0);
            }

            float x = myIO.readFloat("Need an operand: ");

            float y = myIO.readFloat("Another operand: ");

            float solution = performCalculation(x, y, operation);
            myIO.print("Your solution is: " + solution);
        }       
        
    }
    
    public static int chooseOperation(){
        //using ArrayLists
        ArrayList<Integer> choices = new ArrayList<>();
        for (int i  = 1; i < 5; i++){
            choices.add(i);
        }
        
        int choice = myIO.readInt("Choose an operation: 1) Add \t 2)Subtract \t 3) Multiply \t 4) Divide \t 5) Exit");
        
        if (!choices.contains(choice)){
            choice = 0;
        }
        
        return choice;
    }
    
    public static int chooseOperation2(){
        //using enums
        int choice = myIO.readInt("Choose an operation: 1) Add \t 2)Subtract \t 3) Multiply \t 4) Divide \t 5) Exit");
        
        if (Choice.valueOfLabel(choice) == null){
            //did not find our choice
            choice = 0;
        }
        
        return choice;
    }
    
    public static float performCalculation(float x, float y, int operation){
        float solution;
        SimpleCalculator myCalculator = new SimpleCalculator();
        switch (operation) {
            case 1:
                solution = myCalculator.add(x, y);
                break;
            case 2:
                solution = myCalculator.subtract(x, y);
                break;
            case 3:
                solution = myCalculator.multiply(x, y);
                break;
            default:
                solution = myCalculator.divide(x, y);
                break;
        }
        
        return solution;
    }
    
    
}
