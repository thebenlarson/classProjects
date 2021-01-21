/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.vendingmachine.dao;

/**
 *
 * @author benth
 */
public class VendingMachineInvalidCodeException extends Exception{
    public VendingMachineInvalidCodeException(String message) {
        super(message);
    }
    
    public VendingMachineInvalidCodeException(String message, Throwable cause) {
        super(message, cause);
    }
}
