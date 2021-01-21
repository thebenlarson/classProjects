/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.bullsandcows.service;

import com.bl.bullsandcows.data.GameDao;
import com.bl.bullsandcows.data.GameNumberDao;
import com.bl.bullsandcows.data.RoundDao;
import com.bl.bullsandcows.model.Game;
import com.bl.bullsandcows.model.Guess;
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
public class ServiceLayerTest {
    
    @Autowired
    RoundDao roundDao;
    
    @Autowired
    GameNumberDao gameNumberDao;
    
    @Autowired
    GameDao gameDao;
    
    @Autowired
    ServiceInterface service;
    
    public ServiceLayerTest() {
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
     * Test of createGame method, of class ServiceLayer.
     */
    @Test
    public void testCreateGame() {
        service.createGame();
        assertEquals(gameDao.getAll().size(), 1);
    }

    /**
     * Test of getGames method, of class ServiceLayer.
     */
    @Test
    public void testGetGames() {
        service.createGame();
        String output = service.getGames();
        String check = gamesToString(gameDao.getAll());
        assertEquals(output, check);
    }

    /**
     * Test of getGame method, of class ServiceLayer.
     */
    @Test
    public void testGetGame() {
        service.createGame();
        Game game = gameDao.getAll().get(0);
        List<Game> list = new ArrayList<>();
        list.add(game);
        assertEquals(service.getGame(game.getId()), gamesToString(list));
    }

    /**
     * Test of guess method, of class ServiceLayer.
     */
    @Test
    public void testGuess() {
        service.createGame();
        Game game = gameDao.getAll().get(0);
        Guess guess = new Guess();
        guess.setGameId(game.getId());
        String answer = "";
        for (Integer n : game.getAnswer().getNumber()){
            answer += n;
        }
        if (answer.equals("1234")){
            guess.setGuess("1235");
        } else {
            guess.setGuess("1234");
        }
        service.guess(guess);
        game = gameDao.getAll().get(0);
        assertEquals(game.getStatus(), "in progress");
        assertEquals(roundDao.getByGameId(game.getId()).size(), 1);
        
    }
    
    @Test
    public void testGuessIncorrectInput() {
        service.createGame();
        Game game = gameDao.getAll().get(0);
        Guess guess = new Guess();
        guess.setGameId(game.getId());
        guess.setGuess("123456");
        assertEquals(service.guess(guess), "ERROR: Your guess is not 4 digits. Please try again.");
    }
    
    @Test
    public void testGuessDuplicateDigits() {
        service.createGame();
        Game game = gameDao.getAll().get(0);
        Guess guess = new Guess();
        guess.setGameId(game.getId());
        guess.setGuess("1122");
        assertEquals(service.guess(guess), "ERROR: Your guess had duplicate digits. Please try again.");
    }
    
    @Test
    public void testGuessCorrectAndFinished() {
        service.createGame();
        Game game = gameDao.getAll().get(0);
        Guess guess = new Guess();
        guess.setGameId(game.getId());
        String answer = "";
        for (Integer n : game.getAnswer().getNumber()){
            answer += n;
        }
        guess.setGuess(answer);
        service.guess(guess);
        game = gameDao.getAll().get(0);
        assertEquals(game.getStatus(), "finished");
        assertEquals(service.guess(guess), "ERROR: This game is already finished. Please play a different game.");
    }
    
    private String gamesToString(List<Game> list){
        String output = "";
        for (Game g : list){
            output += "{\n\tid: " + g.getId() +
                    ", \n\tstatus: " + g.getStatus();
            if (g.getStatus().equals("finished")){
                String myNumber = "";
                for(Integer num : g.getAnswer().getNumber()){
                    myNumber += num;
                }
                output += ", \n\tanswer: " + myNumber;
            }
            output += "\n},\n";
        }
        output = output.substring(0, output.length() - 2);
        
        return output;
    }
}
