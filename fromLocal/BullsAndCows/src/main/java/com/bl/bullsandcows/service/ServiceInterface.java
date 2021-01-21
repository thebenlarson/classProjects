/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.bullsandcows.service;

import com.bl.bullsandcows.model.Guess;

/**
 *
 * @author benth
 */
public interface ServiceInterface {
    public String createGame();
    
    public String getGames();
    
    public String getGame(int id);
    
    public String guess(Guess guess);
    
    public String getRounds(int gameId);
}
