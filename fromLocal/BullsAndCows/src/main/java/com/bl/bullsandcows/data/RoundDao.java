/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.bullsandcows.data;

import com.bl.bullsandcows.model.Round;
import java.util.List;

/**
 *
 * @author benth
 */
public interface RoundDao {
    Round add(Round todo);

    List<Round> getByGameId(int id);
}
