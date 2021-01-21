/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.bullsandcows.data;

import com.bl.bullsandcows.model.Game;
import java.util.List;

/**
 *
 * @author benth
 */
public interface GameDao {
    Game add(Game todo);

    List<Game> getAll();

    Game findById(int id);

    // true if item exists and is updated
    boolean update(Game todo);

    // true if item exists and is deleted
    boolean deleteById(int id);
}
