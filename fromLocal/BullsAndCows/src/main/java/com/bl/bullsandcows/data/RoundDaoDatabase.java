/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.bullsandcows.data;

import com.bl.bullsandcows.data.GameDaoDatabase.GameMapper;
import com.bl.bullsandcows.model.Game;
import com.bl.bullsandcows.model.GameNumber;
import com.bl.bullsandcows.model.Round;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
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
public class RoundDaoDatabase implements RoundDao{
    
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public RoundDaoDatabase(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Round add(Round round) {
        final String sql = "INSERT INTO rounds(gameId, numberListId, guessTime, results) VALUES(?,?,?,?);";
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update((Connection conn) -> {

            PreparedStatement statement = conn.prepareStatement(
                sql, 
                Statement.RETURN_GENERATED_KEYS);

            statement.setInt(1, round.getGame().getId());
            statement.setInt(2, round.getGuess().getId());
            statement.setTimestamp(3, Timestamp.valueOf(round.getTimestamp()));
            statement.setString(4, round.getResults());
            return statement;

        }, keyHolder);

        round.setId(keyHolder.getKey().intValue());

        return round;
    }

    @Override
    public List<Round> getByGameId(int id) {
        final String sql = "SELECT * FROM rounds WHERE rounds.gameId = ? ORDER BY rounds.guessTime;";
        List<Round> list = jdbcTemplate.query(sql, new RoundMapper(), id);
        fillListGames(list);
        fillListNumbers(list);
        return list;
    }
    
    private void fillListGames(List<Round> list){
        for (Round r : list){
            fillRoundGames(r);
        }
    }
    
    private void fillListNumbers(List<Round> list){
        for (Round r : list){
            fillRoundNumbers(r);
        }
    }
    
    private void fillRoundGames(Round r){
        final String sql = "SELECT g.* FROM rounds r, games g "
                + "WHERE r.gameId = g.id AND r.id = ?;";
        Game g = jdbcTemplate.queryForObject(sql, new GameMapper(), r.getId());
        final String sql2 = "SELECT nl.* FROM numberLists nl, games g "
                + "WHERE nl.id = g.numberListId AND g.id = ?;";
        GameNumber gn = jdbcTemplate.queryForObject(sql2, new GameNumberDaoDatabase.GameNumberMapper(), g.getId());
        gn.setNumber(getNumberList(gn.getId()));
        g.setAnswer(gn);
        r.setGame(g);
    }
    
    private void fillRoundNumbers(Round r){
        final String sql2 = "SELECT nl.* FROM numberLists nl, rounds r "
                + "WHERE nl.id = r.numberListId AND r.id = ?;";
        GameNumber gn = jdbcTemplate.queryForObject(sql2, new GameNumberDaoDatabase.GameNumberMapper(), r.getId());
        gn.setNumber(getNumberList(gn.getId()));
        r.setGuess(gn);
    }
    
    private List<Integer> getNumberList(int id){
        final String SELECT_NUMBERS_IN_LIST = "SELECT n.* FROM numbers n "
                + "WHERE n.numberListId = ? ORDER BY n.place";
        return jdbcTemplate.query(SELECT_NUMBERS_IN_LIST, new GameNumberDaoDatabase.NumberMapper(), 
                id);
    }
    
    private static final class RoundMapper implements RowMapper<Round> {

        @Override
        public Round mapRow(ResultSet rs, int index) throws SQLException {
            Round td = new Round();
            td.setId(rs.getInt("id"));
            td.setTimestamp(rs.getTimestamp("guessTime").toLocalDateTime());
            td.setResults(rs.getString("results"));
            return td;
        }
    }
    
}
