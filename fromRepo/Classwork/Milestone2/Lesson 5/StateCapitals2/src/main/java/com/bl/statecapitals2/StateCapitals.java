/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.statecapitals2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 *
 * @author benth
 */
public class StateCapitals {
    private HashMap<String, Capital> statesAndCapitals = new HashMap<>();

    public HashMap<String, Capital> getStatesAndCapitals() {
        return statesAndCapitals;
    }

    public void setStatesAndCapitals(HashMap<String, Capital> statesAndCapitals) {
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
    
    /**
     *
     * @param myMap
     */
    /*
    public void printHashMap(HashMap<String, String> myMap){
        Set<String> keys = myMap.keySet();
        keys.forEach((key) -> {
            System.out.println(key + "  -  " + myMap.get(key));
        });
    } */
    
    public void printHashMap(HashMap<String, Capital> myMap){
        Set<String> keys = myMap.keySet();
        keys.forEach((key) -> {
            Capital myCapital =  myMap.get(key);
            System.out.println(key + 
                    "  -  " +
                    myCapital.getName() +
                    " | Pop: " + 
                    myCapital.getPopulation() +
                    " | Area: " + 
                    myCapital.getArea()
                    );
        });
    }
    
    public void printHashMap(HashMap<String, Capital> myMap, int limit){
        Set<String> keys = myMap.keySet();
        keys.forEach((key) -> {
            Capital myCapital =  myMap.get(key);
            if (myCapital.getPopulation() >= limit){
                System.out.println(key + "  -  " +myCapital.getName() +" | Pop: " +  myCapital.getPopulation() +" | Area: " + myCapital.getArea() );
            }
        });
    }
    
    public void loadMap(){
        ArrayList<String> states = new ArrayList<>(Arrays.asList("Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut", "Delaware", "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming"));
        ArrayList<String> capitals = new ArrayList<>(Arrays.asList("Montgomery", "Juneau", "Phoenix", "Little Rock", "Sacramento", "Denver", "Hartford", "Dover", "Tallahassee", "Atlanta", "Honolulu", "Boise", "Springfield", "Indianapolis", "Des Moines", "Topeka", "Frankfort", "Baton Rouge", "Augusta", "Annapolis", "Boston", "Lansing", "Saint Paul", "Jackson", "Jefferson City", "Helena", "Lincoln", "Carson City", "Concord", "Trenton", "Santa Fe", "Albany", "Raleigh", "Bismarck", "Columbus", "Oklahoma City", "Salem", "Harrisburg", "Providence", "Columbia", "Pierre", "Nashville", "Austin", "Salt Lake City", "Montpelier", "Richmond", "Olympia", "Charleston", "Madison", "Cheyenne"));
        ArrayList<Integer> population = new ArrayList<>(Arrays.asList(198218, 31275, 1660272, 193524, 508529, 716492, 124775, 36047, 181376, 498044, 359870, 205671, 116250, 867125, 203433, 127473, 25527, 225374, 19136, 38394, 694583, 114297, 285068, 173514, 43079, 28190, 258379, 55274, 42695, 84913, 75764, 97856, 403892, 61272, 892553, 649021, 154637, 49528, 178042, 129272, 13646, 691243, 964254, 186440, 7855, 204214, 46478, 51400, 233209, 59466));
        ArrayList<Double> areas = new ArrayList<>(Arrays.asList(159.8, 2716.7, 517.6, 116.2, 97.9, 153.3, 17.3, 22.4, 95.7, 133.5, 68.4, 63.8, 54.0, 361.5, 75.8, 56.0, 14.7, 76.8, 55.4, 6.73, 89.6, 35.0, 52.8, 104.9, 27.3, 14.0, 74.6, 143.4, 64.3, 7.66, 37.3, 21.4, 114.6, 26.9, 210.3, 620.3, 45.7, 8.11, 18.5, 125.2, 13.0, 525.9, 305.1, 109.1, 10.2, 60.1, 16.7, 31.6, 68.7, 21.1));
        
        for (int i = 0; i < 50; i++){
            String state = states.get(i);
            String capital = capitals.get(i);
            double area = areas.get(i);
            int pop = population.get(i);
            statesAndCapitals.put(state, new Capital(capital, pop, area) );
        }
    }
}
