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
public class Square extends Shape {
    private int side;
            
    @Override
    public float getArea(){
        return side * side;
    }
    
    @Override
    public float getPerimeter(){
        return side * 4;
    }
}
