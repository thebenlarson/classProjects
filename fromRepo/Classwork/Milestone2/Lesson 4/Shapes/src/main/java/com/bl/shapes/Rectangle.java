/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.shapes;

/**
 *
 * @author benth
 */
public class Rectangle extends Shape {
    private int side1;
    private int side2;
            
    @Override
    public float getArea(){
        return side1 * side2;
    }
    
    @Override
    public float getPerimeter(){
        return side1 * 2 + side2 * 2;
    }
}
