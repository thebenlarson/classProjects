/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.bullsandcows.data;

import com.bl.bullsandcows.model.Game;
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
public class GameDaoDatabaseTest {
    
    @Autowired
    RoundDao roundDao;
    
    @Autowired
    GameNumberDao gameNumberDao;
    
    @Autowired
    GameDao gameDao;
    
    public GameDaoDatabaseTest() {
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
     * Test of add method, of class GameDaoDatabase.
     */
    @Test
    public void testAddGet() {
        List<Integer> list = new ArrayList<>();
        list.add(1); 
        list.add(2);
        list.add(3);
        list.add(4);
        
        GameNumber gameNumber = new GameNumber();
        gameNumber.setNumber(list);
        
        gameNumber = gameNumberDao.add(gameNumber);
        GameNumber gameNumber2 = gameNumberDao.add(gameNumber);
        
        
        Game game = new Game();
        game.setStatus("in progress");
        game.setAnswer(gameNumber);
        game = gameDao.add(game);
        
        Game g2 = gameDao.findById(game.getId());
        assertEquals(game.getId(), g2.getId());
    }

    /**
     * Test of getAll method, of class GameDaoDatabase.
     */
    @Test
    public void testGetAll() {
        List<Integer> list = new ArrayList<>();
        list.add(1); 
        list.add(2);
        list.add(3);
        list.add(4);
        
        GameNumber gameNumber = new GameNumber();
        gameNumber.setNumber(list);
        
        gameNumber = gameNumberDao.add(gameNumber);
        GameNumber gameNumber2 = gameNumberDao.add(gameNumber);
        
        
        Game game = new Game();
        game.setStatus("in progress");
        game.setAnswer(gameNumber);
        game = gameDao.add(game);
        Game g2 = gameDao.add(game);
        assertEquals(gameDao.getAll().size(), 2);
    }

    /**
     * Test of update method, of class GameDaoDatabase.
     */
    @Test
    public void testUpdate() {
        List<Integer> list = new ArrayList<>();
        list.add(1); 
        list.add(2);
        list.add(3);
        list.add(4);
        
        GameNumber gameNumber = new GameNumber();
        gameNumber.setNumber(list);
        
        gameNumber = gameNumberDao.add(gameNumber);
        GameNumber gameNumber2 = gameNumberDao.add(gameNumber);
        
        
        Game game = new Game();
        game.setStatus("in progress");
        game.setAnswer(gameNumber);
        game = gameDao.add(game);
        assertEquals(gameDao.findById(game.getId()).getStatus(), "in progress");
        game.setStatus("finished");
        gameDao.update(game);
        assertEquals(gameDao.findById(game.getId()).getStatus(), "finished");
    }

    /**
     * Test of deleteById method, of class GameDaoDatabase.
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
        GameNumber gameNumber2 = gameNumberDao.add(gameNumber);
        
        
        Game game = new Game();
        game.setStatus("in progress");
        game.setAnswer(gameNumber);
        game = gameDao.add(game);
        assertEquals(gameDao.getAll().size(), 1);
        gameDao.deleteById(game.getId());
        assertEquals(gameDao.getAll().size(), 0);
    }
    
}
