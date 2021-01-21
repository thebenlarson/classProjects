/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.statecapitals2;

/**
 *
 * @author benth
 */
public class Capital {
    private final String name;
    private final int population;
    private final double area;

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    public double getArea() {
        return area;
    }

    public Capital(String name, int population, double area) {
        this.name = name;
        this.population = population;
        this.area = area;
    }
    
}
