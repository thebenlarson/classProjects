/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.bullsandcows.data;

import com.bl.bullsandcows.model.GameNumber;
import java.util.List;

/**
 *
 * @author benth
 */
public interface GameNumberDao {
    GameNumber add(GameNumber todo);

    List<GameNumber> getAll();

    GameNumber findById(int id);

    // true if item exists and is updated
    //boolean update(GameNumber todo);

    // true if item exists and is deleted
    boolean deleteById(int id);
    
    public void deleteAll();    
}
