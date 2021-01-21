/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.bullsandcows.data;

import com.bl.bullsandcows.model.GameNumber;
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
public class GameNumberDaoDatabase implements GameNumberDao{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public GameNumberDaoDatabase(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public GameNumber add(GameNumber gameNumber) {

        final String sql = "INSERT INTO numberLists VALUES();";
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update((Connection conn) -> {

            PreparedStatement statement = conn.prepareStatement(
                sql, 
                Statement.RETURN_GENERATED_KEYS);
            return statement;

        }, keyHolder);

        gameNumber.setId(keyHolder.getKey().intValue());
        addNumbers(gameNumber);
        

        return gameNumber;
    }
    
    private void addNumbers(GameNumber gameNumber){
        int i = 0;
        for(Integer num : gameNumber.getNumber()){
            addNumber(num, i, gameNumber.getId());
            i++;
        }        
    }
    
    private void addNumber(int num, int place, int gameId){
        //add to database
        final String sql = "INSERT INTO numbers(value, place, numberListId) VALUES(?,?,?);";
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update((Connection conn) -> {

            PreparedStatement statement = conn.prepareStatement(
                sql, 
                Statement.RETURN_GENERATED_KEYS);

            statement.setInt(1, num);
            statement.setInt(2, place);
            statement.setInt(3, gameId);
            return statement;

        }, keyHolder);
    }

    @Override
    public List<GameNumber> getAll() {
        final String sql = "SELECT id FROM numberLists;";
        List<GameNumber> list = jdbcTemplate.query(sql, new GameNumberMapper());
        addNumbersToLists(list);
        return list;
    }
    
    private void addNumbersToLists(List<GameNumber> list){
        for (GameNumber gn : list){
            gn.setNumber(getNumberList(gn.getId()));
        }
    }

    @Override
    public GameNumber findById(int id) {

        final String sql = "SELECT id "
                + "FROM numberLists WHERE id = ?;";

        GameNumber output = jdbcTemplate.queryForObject(sql, new GameNumberMapper(), id);
        output.setNumber(getNumberList(id));
        
        return output;
    }
    
    private List<Integer> getNumberList(int id){
        final String SELECT_NUMBERS_IN_LIST = "SELECT n.* FROM numbers n "
                + "WHERE n.numberListId = ? ORDER BY n.place";
        return jdbcTemplate.query(SELECT_NUMBERS_IN_LIST, new NumberMapper(), 
                id);
    }
    
    private void deleteNumbers(int id){
        final String DELETE_NUMBERS = "DELETE FROM numbers "
                + "WHERE numberListId = ?";
        jdbcTemplate.update(DELETE_NUMBERS, id);
    }

//    @Override
//    public boolean update(GameNumber gameNumber) {
//        deleteNumbers(gameNumber.getId());
//        addNumbers(gameNumber);
//        return true;
//    }

    @Override
    public boolean deleteById(int id) {
        deleteNumbers(id);
        final String sql = "DELETE FROM numberLists WHERE id = ?;";
        return jdbcTemplate.update(sql, id) > 0;
    }
    
    public static final class GameNumberMapper implements RowMapper<GameNumber> {

        @Override
        public GameNumber mapRow(ResultSet rs, int index) throws SQLException {
            GameNumber gn = new GameNumber();
            gn.setId(rs.getInt("id"));
            return gn;
        }
    }
    
    public static final class NumberMapper implements RowMapper<Integer> {

        @Override
        public Integer mapRow(ResultSet rs, int index) throws SQLException {
            Integer obj = rs.getInt("value");
            return obj;
        }
    }
    
    @Override
    public void deleteAll(){
        final String sql = "DELETE FROM rounds";
        final String sql2 = "DELETE FROM games";
        final String sql3 = "DELETE FROM numbers";
        final String sql4 = "DELETE FROM numberLists";
        jdbcTemplate.update(sql);
        jdbcTemplate.update(sql2);
        jdbcTemplate.update(sql3);
        jdbcTemplate.update(sql4);
    }
    
}
