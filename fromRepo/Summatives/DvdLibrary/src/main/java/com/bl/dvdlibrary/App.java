/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.dvdlibrary;

import com.bl.dvdlibrary.controller.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author benth
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext ctx = 
           new ClassPathXmlApplicationContext("applicationContext.xml");
        DvdLibraryController controller = 
           ctx.getBean("controller", DvdLibraryController.class);
        controller.run();
    }
}
