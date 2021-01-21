/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.bullsandcows.data;

import com.bl.bullsandcows.model.GameNumber;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 *
 * @author benth
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class GameNumberDaoDatabaseTest {
    
    @Autowired
    RoundDao roundDao;
    
    @Autowired
    GameNumberDao gameNumberDao;
    
    @Autowired
    GameDao gameDao;
    
    public GameNumberDaoDatabaseTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        gameNumberDao.deleteAll();
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of add method, of class GameNumberDaoDatabase.
     */
    @Test
    public void testAddGetAll() {
        List<Integer> list = new ArrayList<>();
        list.add(1); 
        list.add(2);
        list.add(3);
        list.add(4);
        
        GameNumber gameNumber = new GameNumber();
        gameNumber.setNumber(list);
        
        gameNumber = gameNumberDao.add(gameNumber);
        GameNumber gameNumber2 = gameNumberDao.add(gameNumber);
        assertEquals(gameNumberDao.getAll().size(), 2);
    }
    
    /**
     * Test of findById method, of class GameNumberDaoDatabase.
     */
    @Test
    public void testFindById() {
        List<Integer> list = new ArrayList<>();
        list.add(1); 
        list.add(2);
        list.add(3);
        list.add(4);
        
        GameNumber gameNumber = new GameNumber();
        gameNumber.setNumber(list);
        
        gameNumber = gameNumberDao.add(gameNumber);
        GameNumber gn2 = gameNumberDao.findById(gameNumber.getId());
        assertEquals(gameNumber.getId(), gn2.getId());
    }

    /**
     * Test of deleteById method, of class GameNumberDaoDatabase.
     */
    @Test
    public void testDeleteById() {
        List<Integer> list = new ArrayList<>();
        list.add(1); 
        list.add(2);
        list.add(3);
        list.add(4);
        
        GameNumber gameNumber = new GameNumber();
        gameNumber.setNumber(list);
        
        gameNumber = gameNumberDao.add(gameNumber);
        
        assertEquals(gameNumberDao.getAll().size(), 1);
        gameNumberDao.deleteById(gameNumber.getId());
        assertEquals(gameNumberDao.getAll().size(), 0);
    }

    /**
     * Test of deleteAll method, of class GameNumberDaoDatabase.
     */
    @Test
    public void testDeleteAll() {
        //this function was made for unit testing- it deletes ALL info in the database
        List<Integer> list = new ArrayList<>();
        list.add(1); 
        list.add(2);
        list.add(3);
        list.add(4);
        
        GameNumber gameNumber = new GameNumber();
        gameNumber.setNumber(list);
        
        gameNumber = gameNumberDao.add(gameNumber);
        
        assertEquals(gameNumberDao.getAll().size(), 1);
        gameNumberDao.deleteAll();
        assertEquals(gameNumberDao.getAll().size(), 0);
    }
    
}
