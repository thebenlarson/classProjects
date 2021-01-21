/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.minizork;

/**
 *
 * @author benth
 */
import java.util.Scanner;

public class MiniZork {

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);

        System.out.println("You are standing in an open field west of a white house,");
        System.out.println("With a boarded front door.");
        System.out.println("There is a small mailbox here.");
        System.out.print("Go to the house, or open the mailbox? ");

        String action = userInput.nextLine();

        if (action.equals("open the mailbox")) {
            System.out.println("You open the mailbox.");
            System.out.println("It's really dark in there.");
            System.out.print("Look inside or stick your hand in? ");
            action = userInput.nextLine();

            if (action.equals("look inside")) {
                System.out.println("You peer inside the mailbox.");
                System.out.println("It's really very dark. So ... so very dark.");
                System.out.print("Run away or keep looking? ");
                action = userInput.nextLine();

                if (action.equals("keep looking")) {
                    System.out.println("Turns out, hanging out around dark places isn't a good idea.");
                    System.out.println("You've been eaten by a grue.");
                } else if (action.equals("run away")) {
                    System.out.println("You run away screaming across the fields - looking very foolish.");
                    System.out.println("But you alive. Possibly a wise choice.");
                }
            } else if (action.equals("stick your hand in")) { 
                System.out.println("You place your hand in the mailbox...");
                System.out.println("Theres a button");
                System.out.print("Press the button or leave?? ");
                action = userInput.nextLine();

                if (action.equals("press the button")) {
                    System.out.println("Turns out, it wasn't a button. It was a tongue.");
                    System.out.println("You've been eaten by a mailbox.");
                } else if (action.equals("leave")) {
                    System.out.println("You turn around to leave, but its too late.");
                    System.out.println("You are eaten by the mailbox. Never disturb a mailbox in its natural habitat");
                }
            }
        } else if (action.equals("go to the house")) {
            System.out.println("You approach the house.");
                System.out.println("It's really very creepy. There are rats everywhere.");
                System.out.println("There's a doorbell.");
                System.out.print("Ring doorbell or leave? ");
                action = userInput.nextLine();

                if (action.equals("ring doorbell")) {
                    System.out.println("Nothing happens.");
                    System.out.println("Ring again or leave?");
                    action = userInput.nextLine();
                    
                    if (action.equals("ring again")) {
                        System.out.println("You here something in the distance... It's getting louder...");
                        System.out.println("YOU'VE GOT MAILLLLLL ---UUUHUUHHUHUH");
                        System.out.println("You were eaten by the mailbox");
                    } else if (action.equals("leave")) {
                        System.out.println("You run away.");
                        System.out.println("You realize the mailbox is missing. How strange?");
                    }
                } else if (action.equals("leave")) {
                    System.out.println("You turn to leave, but have fallen through a trapdoor!!");
                    System.out.println("You land on your butt. Everywhere you look you see letters, envelopes, stamps, and packages.");
                    System.out.println("You see a light in the distance");
                    System.out.println("Walk to light or stay in place?");
                    action = userInput.nextLine();
                    
                    if (action.equals("walk to light")) {
                        System.out.println("You walk to the light, but it goes out");
                        System.out.println("YOU'VE GOT MAILLLLLL ---UUUHUUHHUHUH");
                        System.out.println("You were eaten by the mailbox");
                    } else if (action.equals("stay in place")) {
                        System.out.println("You stay right where you are. For ten years, petrified by fear");
                        System.out.println("Finally you muster up the courage to do something");
                        System.out.println("As you begin your escape, you see a mailbox.");
                        System.out.println("Starving, you eat the mailbox and escape.");
                    }
                }
            } else if (action.equals("stick your hand in")) { 
                System.out.println("You place your hand in the mailbox...");
                System.out.println("Theres a button");
                System.out.print("Press the button or leave?? ");
                action = userInput.nextLine();

                if (action.equals("press the button")) {
                    System.out.println("Turns out, it wasn't a button. It was a tongue.");
                    System.out.println("You've been eaten by a mailbox.");
                } else if (action.equals("leave")) {
                    System.out.println("You turn around to leave, but its too late.");
                    System.out.println("You are eaten by the mailbox. Never disturb a mailbox in its natural habitat");
                }
        }
    }
}
