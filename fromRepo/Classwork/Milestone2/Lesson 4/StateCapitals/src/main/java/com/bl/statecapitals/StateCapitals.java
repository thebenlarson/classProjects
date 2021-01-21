/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.statecapitals;

import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author benth
 */
public class StateCapitals {
    private HashMap<String, String> statesAndCapitals = new HashMap<String, String>();

    public HashMap<String, String> getStatesAndCapitals() {
        return statesAndCapitals;
    }

    public void setStatesAndCapitals(HashMap<String, String> statesAndCapitals) {
        this.statesAndCapitals = statesAndCapitals;
    }
    
    public void printHashMapKeys(HashMap<String, String> myMap){
        Set<String> keys = myMap.keySet();
        keys.forEach((key) -> {
            System.out.println(key);
        });
    }
    
    public void printHashMapValues(HashMap<String, String> myMap){
        Set<String> keys = myMap.keySet();
        keys.forEach((key) -> {
            System.out.println(myMap.get(key));
        });
    }
    
    public void printHashMap(HashMap<String, String> myMap){
        Set<String> keys = myMap.keySet();
        keys.forEach((key) -> {
            System.out.println(key + "  -  " + myMap.get(key));
        });
    }
    
    public void loadMap(){
        statesAndCapitals.put("Alabama", "Montgomerey");
        statesAndCapitals.put("Alaska", "Juneau");
        statesAndCapitals.put("Arizona", "Phoenix");
        statesAndCapitals.put("Arkansas", "Little Rock");
        statesAndCapitals.put("California", "Sacramento");
        statesAndCapitals.put("Colorado", "Denver");
        statesAndCapitals.put("Connecticut", "Hartford");
        statesAndCapitals.put("Delaware", "Dover");
        statesAndCapitals.put("Florida", "Tallahassee");
        statesAndCapitals.put("Georgia", "Atlanta");
        statesAndCapitals.put("Hawaii", "Honolulu");
        statesAndCapitals.put("Idaho", "Boise");
        statesAndCapitals.put("Illinois", "Springfield");
        statesAndCapitals.put("Indiana", "Indianapolis");
        statesAndCapitals.put("Iowa", "Des Moines");
        statesAndCapitals.put("Kansas", "Topeka");
        statesAndCapitals.put("Kentucky", "Frankfort");
        statesAndCapitals.put("Louisiana", "Baton Rouge");
        statesAndCapitals.put("Maine", "Augusta");
        statesAndCapitals.put("Maryland", "Annapolis");
        statesAndCapitals.put("Massachusetts", "Boston");
        statesAndCapitals.put("Michigan", "Lansing");
        statesAndCapitals.put("Minnesota", "Saint Paul");
        statesAndCapitals.put("Mississippi", "Jackson");
        statesAndCapitals.put("Missouri", "Jefferson City");
        statesAndCapitals.put("Montana", "Helena");
        statesAndCapitals.put("Nebraska", "Lincoln");
        statesAndCapitals.put("Nevada", "Carson City");
        statesAndCapitals.put("New Hampshire", "Concord");
        statesAndCapitals.put("New Jersey", "Trenton");
        statesAndCapitals.put("New Mexico", "Santa Fe");
        statesAndCapitals.put("New York", "Albany");
        statesAndCapitals.put("North Carolina", "Raleigh");
        statesAndCapitals.put("North Dakota", "Bismark");
        statesAndCapitals.put("Ohio", "Columbus");
        statesAndCapitals.put("Oklahoma", "Oklahoma City");
        statesAndCapitals.put("Oregon", "Salem");
        statesAndCapitals.put("Pennsylvania", "Harrisburg");
        statesAndCapitals.put("Rhode Island", "Providence");
        statesAndCapitals.put("South Carolina", "Columbia");
        statesAndCapitals.put("South Dakota", "Pierre");
        statesAndCapitals.put("Tennessee", "Nashville");
        statesAndCapitals.put("Texas", "Austin");
        statesAndCapitals.put("Utah", "Salt Lake City");
        statesAndCapitals.put("Vermont", "Montpelier");
        statesAndCapitals.put("Virginia", "Richmond");
        statesAndCapitals.put("Washington", "Olympia");
        statesAndCapitals.put("West Virginia", "Charleston");
        statesAndCapitals.put("Wisconsin", "Madison");
        statesAndCapitals.put("Wyoming", "Cheyenne");
    }
}
