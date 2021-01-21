/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.fruitsalad;

/**
 *
 * @author benth
 */
public class FruitSalad {
    public static void main(String[] args) {
        String[] fruit = {"Kiwi Fruit", "Gala Apple", "Granny Smith Apple", "Cherry Tomato", "Gooseberry", "Beefsteak Tomato", "Braeburn Apple", "Blueberry", "Strawberry", "Navel Orange", "Pink Pearl Apple",  "Raspberry", "Blood Orange", "Sungold Tomato", "Fuji Apple", "Blackberry", "Banana", "Pineapple", "Florida Orange", "Kiku Apple", "Mango", "Satsuma Orange", "Watermelon", "Snozzberry"};
        
        String[] fruitSalad = new String[12];
        boolean limitReached = false;
        
        String[] apples = sortFruit(fruit, "apple");
        String[] oranges = sortFruit(fruit, "orange");
        String[] berries = sortFruit(fruit, "berry");
        String[] tomatos = sortFruit(fruit, "tomato");
        String[] other = {"Kiwi Fruit", "Banana", "Watermelon", "Mango"};
        
        // Code Recipe for fruit salad should go here!
        //place berries
        for (int i = 0; i < berries.length; i++){
            if (i >= 12){
                break;
            }
            fruitSalad[i] = berries[i];
        }
        
    }
    
    public static String[] sortFruit(String[] fruit, String key){
        String[] sorted = new String[fruit.length];
        int count = 0;
        
        for (int i = 0; i < fruit.length; i++){
            if (fruit[i].toLowerCase().contains(key)){
                sorted[count] = fruit[i];
                count++;
            }
        }
        
        return sorted;
    }
}
