/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.flooring.service;

/**
 *
 * @author benth
 */
public class FlooringNoOrderException extends Exception {
    public FlooringNoOrderException(String message) {
        super(message);
    }
    
    public FlooringNoOrderException(String message, Throwable cause) {
        super(message, cause);
    }
}
