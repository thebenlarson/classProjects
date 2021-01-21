/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.vendingmachine;

import com.bl.vendingmachine.controller.*;
import com.bl.vendingmachine.dao.*;
import com.bl.vendingmachine.service.*;
import com.bl.vendingmachine.ui.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author benth
 */
public class App {
    
    public static void main(String[] args) {
        // \u000d ApplicationContext ctx = 
           new ClassPathXmlApplicationContext("applicationContext.xml");
        VendingMachineController controller = 
           ctx.getBean("controller", VendingMachineController.class);
        controller.run();
    }
}
