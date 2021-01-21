/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.functionalunittest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author benth
 */
public class ChildrenTest {
    Children children = new Children();
    
    public ChildrenTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testTT() {
        assertTrue(children.areWeInTrouble(true, true));
    }
    
    @Test
    public void testFF() {
        assertTrue(children.areWeInTrouble(false, false));
    }
    
    @Test
    public void testTF() {
        assertFalse(children.areWeInTrouble(true, false));
    }
    
}
