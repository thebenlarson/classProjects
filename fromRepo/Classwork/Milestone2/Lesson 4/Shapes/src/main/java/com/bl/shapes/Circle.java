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
public class Circle extends Shape{
    protected float radius;
    
    @Override
    public float getArea(){
        return radius * (float)Math.PI * radius;
    }
    
    @Override
    public float getPerimeter(){
        return radius * (float)Math.PI * 2;
    }
}
