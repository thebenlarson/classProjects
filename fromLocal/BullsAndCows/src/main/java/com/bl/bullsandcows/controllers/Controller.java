/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.bullsandcows.controllers;

import com.bl.bullsandcows.model.Guess;
import com.bl.bullsandcows.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author benth
 */
@RestController
@RequestMapping("/api")
public class Controller {
    
    @Autowired
    ServiceInterface service;
    
    @PostMapping("/begin")
    @ResponseStatus(HttpStatus.CREATED)
    public String create() {
        return service.createGame();
    }
    
    @GetMapping("/game")
    public ResponseEntity<String> getGames() {
        String result = service.getGames();
        if (result.equals("")){
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(result);
    }
    
    @GetMapping("/game/{id}")
    public ResponseEntity<String> getGame(@PathVariable int id) {
        String result = service.getGame(id);
        if (result.equals("")){
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(result);
    }
    
    @PostMapping("guess")
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@RequestBody Guess guess) {
        return service.guess(guess);
    }
    
    @GetMapping("/rounds/{id}")
    public ResponseEntity<String> getRounds(@PathVariable int id) {
        String result = service.getRounds(id);
        if (result.equals("")){
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(result);
    }
    
}
