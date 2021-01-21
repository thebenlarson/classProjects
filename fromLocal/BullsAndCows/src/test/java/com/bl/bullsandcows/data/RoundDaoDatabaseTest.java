/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.bullsandcows.data;

import com.bl.bullsandcows.model.Game;
import com.bl.bullsandcows.model.GameNumber;
import com.bl.bullsandcows.model.Round;
import java.time.LocalDateTime;
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
public class RoundDaoDatabaseTest {
    
    @Autowired
    RoundDao roundDao;
    
    @Autowired
    GameNumberDao gameNumberDao;
    
    @Autowired
    GameDao gameDao;
    
    public RoundDaoDatabaseTest() {
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
     * Test of add method, of class RoundDaoDatabase.
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
        
        Round round = new Round();
        
        round.setGame(game);
        round.setGuess(gameNumber2);
        round.setResults("e:0:p:0");
        round.setTimestamp(LocalDateTime.now());
        
        round = roundDao.add(round);
        
        Round r2 = roundDao.getByGameId(game.getId()).get(0);
        assertEquals(round.getId(), r2.getId());
        //assertEquals(round, r2);
        
    }

    
}
