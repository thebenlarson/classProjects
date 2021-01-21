/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.bullsandcows.data;

import com.bl.bullsandcows.model.Game;
import com.bl.bullsandcows.model.GameNumber;
import com.bl.bullsandcows.data.GameNumberDaoDatabase.GameNumberMapper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

/**
 *
 * @author benth
 */
@Repository
@Profile("database")
public class GameDaoDatabase implements GameDao {
    
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public GameDaoDatabase(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Game add(Game game) {

        final String sql = "INSERT INTO games(numberListId, status) VALUES(?,?);";
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update((Connection conn) -> {

            PreparedStatement statement = conn.prepareStatement(
                sql, 
                Statement.RETURN_GENERATED_KEYS);

            statement.setInt(1, game.getAnswer().getId());
            statement.setString(2, game.getStatus());
            return statement;

        }, keyHolder);

        game.setId(keyHolder.getKey().intValue());

        return game;
    }

    @Override
    public List<Game> getAll() {
        final String sql = "SELECT * FROM games;";
        List<Game> list = jdbcTemplate.query(sql, new GameMapper());
        addNumbersToList(list);
        return list;
    }

    @Override
    public Game findById(int id) {

        final String sql = "SELECT * "
                + "FROM games WHERE id = ?;";

        Game obj = jdbcTemplate.queryForObject(sql, new GameMapper(), id);
        addNumber(obj);
        return obj;
    }
    
    private void addNumber(Game game){
        final String sql = "SELECT nl.* FROM numberLists nl, games g "
                + "WHERE nl.id = g.numberListId AND g.id = ?;";
        GameNumber gn = jdbcTemplate.queryForObject(sql, new GameNumberMapper(), game.getId());
        gn.setNumber(getNumberList(gn.getId()));
        game.setAnswer(gn);
    }
    
    private List<Integer> getNumberList(int id){
        final String SELECT_NUMBERS_IN_LIST = "SELECT n.* FROM numbers n "
                + "WHERE n.numberListId = ? ORDER BY n.place";
        return jdbcTemplate.query(SELECT_NUMBERS_IN_LIST, new GameNumberDaoDatabase.NumberMapper(), 
                id);
    }
    
    private void addNumbersToList(List<Game> list){
        for(Game g : list){
            addNumber(g);
        }
    }

    @Override
    public boolean update(Game game) {

        final String sql = "UPDATE games SET "
                + "numberListId = ?, "
                + "status = ? "
                + "WHERE id = ?;";

        return jdbcTemplate.update(sql,
                game.getAnswer().getId(),
                game.getStatus(),
                game.getId()) > 0;
    }

    @Override
    public boolean deleteById(int id) {
        final String sql = "DELETE FROM games WHERE id = ?;";
        return jdbcTemplate.update(sql, id) > 0;
    }
    
    private GameNumber getGameNumberForGame(Game game) {
        final String SELECT_GAME_NUMBER_FOR_GAME = "SELECT n.* FROM games g "
                + "JOIN numberLists n ON n.id = g.numberListId WHERE g.id = ?";
        return jdbcTemplate.queryForObject(SELECT_GAME_NUMBER_FOR_GAME, new GameNumberMapper(), 
                game.getId());
    }
    

    public static final class GameMapper implements RowMapper<Game> {

        @Override
        public Game mapRow(ResultSet rs, int index) throws SQLException {
            Game td = new Game();
            td.setId(rs.getInt("id"));
            td.setStatus(rs.getString("status"));
            return td;
        }
    }
}
