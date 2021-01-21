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
import com.bl.bullsandcows.model.GameNumber;
import com.bl.bullsandcows.model.Guess;
import com.bl.bullsandcows.model.Round;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 *
 * @author benth
 */
@Repository
@Service
@Profile("database")
public class ServiceLayer implements ServiceInterface{
    @Autowired
    GameNumberDao gameNumberDao;
    
    @Autowired
    GameDao gameDao;
    
    @Autowired
    RoundDao roundDao;
    
    private final int GAME_SIZE = 4;

    
    public String createGame(){
        //make new game number
        GameNumber gn = new GameNumber();
        gn.setNumber(getRandomNumber());
        gn = gameNumberDao.add(gn);
        //save in db
        //make new game and save in db
        Game game = new Game();
        game.setAnswer(gn);
        game.setStatus("in progress");
        gameDao.add(game);
        
        
        
        return "Created Game: " + game.getId();
    }
    
    private List<Integer> getRandomNumber(){
        Random rand = new Random(); 
        List<Integer> list = new ArrayList<>();
        do {
            int random = rand.nextInt(10); 
            if (!list.contains(random)){
                list.add(random);
            }
        } while (list.size() < GAME_SIZE);
        
        
        return list;
    }

    @Override
    public String getGames() {
        return gamesToString(gameDao.getAll());
    }

    @Override
    public String getGame(int id) {
        List<Game> list = new ArrayList<>();
        list.add(gameDao.findById(id));
        return gamesToString(list);
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

    @Override
    public String guess(Guess guess) {
        //if guess.size is not equal to 4 then throw an error
        Game game = gameDao.findById(guess.getGameId());
        List<Integer> list = guessToNumbers(guess.getGuess());
        
        if (guess.getGuess().length() != GAME_SIZE){
            return "ERROR: Your guess is not " + GAME_SIZE + " digits. Please try again.";
        }
        
        if (game.getStatus().equals("finished")){
            return "ERROR: This game is already finished. Please play a different game.";
        }
        
        if (list == null){
            return "ERROR: Your guess had duplicate digits. Please try again.";
        }
        
        //check for duplicate numbers in guess as well
        
        GameNumber gn = new GameNumber();
        
        gn.setNumber(list);
        gn = gameNumberDao.add(gn);
        
        
        String results = calculateResults(game.getAnswer(), gn);
        
        Round round = new Round();
        round.setGame(game);
        round.setGuess(gn);
        round.setResults(results);
        round.setTimestamp(LocalDateTime.now());
        //create a round and return it
        round = roundDao.add(round);
        
        String output = "{ id: " + round.getId()
                + ", gameId: " + round.getGame().getId()
                + ", guess: " + guess.getGuess()
                + ", timestamp: " + round.getTimestamp()
                + ", result: " + round.getResults()
                + "}";
        
        if (results.equals("e:"+GAME_SIZE+":p:0")){
            //they win
            game.setStatus("finished");
            gameDao.update(game);
            output += " You win!";
        }
        return output;
    }
    
    
    private List<Integer> guessToNumbers(String guess){
        List<Integer> list = new ArrayList<>();
        try{
            for (int i = 0; i < GAME_SIZE; i++){
                int num = Integer.parseInt(guess.substring(i, i + 1));
                if (list.contains(num)){
                    //error - duplicate
                    System.out.println("Duplicate digits entered. Please try again.");
                    return null;
                }
                list.add(num);
            }
        } catch(Exception e){
            System.out.println(e.getMessage());
        }

        return list;
    }
    
    private String calculateResults(GameNumber answer, GameNumber guess){
        
        List<Integer> answerList = answer.getNumber();
        List<Integer> guessList = guess.getNumber();
        
        int exact = 0;
        int partial = 0;
        for (int i = 0; i < GAME_SIZE; i++){
            if (Objects.equals(guessList.get(i), answerList.get(i))){
                exact++;
            } else if (answerList.contains(guessList.get(i))){
                partial++;
            }
        }
        
        return "e:" + exact + ":p:" + partial;
    }

    @Override
    public String getRounds(int gameId) {
        String output = "";
        List<Round> list = roundDao.getByGameId(gameId);
        for (Round r : list){
            
            String guess = "";
            for (Integer num : r.getGuess().getNumber()){
                guess += num;
            }
            
            output += "{"
            + " id: " + r.getId()
            + ", gameId: " + r.getGame().getId()
            + ", guess: " + guess
            + ", results: " + r.getResults()
            + "}, ";
        }
        return output;
    }
}
