/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.fruitsbasket;

/**
 *
 * @author benth
 */
public class FruitsBasket {
    public static void main(String[] args) {
        String[] fruit = {"Orange", "Apple", "Orange", "Apple", "Orange", "Apple", "Orange", "Apple", "Orange", "Orange", "Orange", "Apple", "Orange", "Orange", "Apple", "Orange", "Orange", "Apple", "Apple", "Orange", "Apple", "Apple", "Orange", "Orange", "Apple", "Apple", "Apple", "Apple", "Orange", "Orange", "Apple", "Apple", "Orange", "Orange", "Orange", "Orange", "Apple", "Apple", "Apple", "Apple", "Orange", "Orange", "Apple", "Orange", "Orange", "Apple", "Orange", "Orange", "Apple", "Apple", "Orange", "Orange", "Apple", "Orange", "Apple", "Orange", "Apple", "Orange", "Apple", "Orange", "Orange"};
        int orange = 0, apple = 0;
        // Fruit sorting code goes here!
        
        for (int i  = 0; i < fruit.length; i++){
            if (fruit[i].equals("Orange")){
                orange++;
            } else {
                apple++;
            }
        }
        
        String[] oranges = new String[orange];
        String[] apples = new String[apple];
        
        sortFruit(oranges, "Oranges");
        sortFruit(apples, "Apples");
        
        System.out.println("Total# of Fruit in Basket: " + orange + apple);

    }
    
    public static void sortFruit(String[] fruit, String appleOrOrange){
        for (int i = 0; i < fruit.length; i++){
            fruit[i] = appleOrOrange;
        }
    }
}
