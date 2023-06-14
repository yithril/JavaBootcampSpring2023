package com.zork.models.dao;

import com.zork.models.Player;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PlayerDAO {
    private DataSource dataSource;

    public PlayerDAO(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public void createPlayer(Player player){
        String query = "INSERT INTO player (name, gender, level, experience, playerHealth, raceID, playableClassID)" +
                       "VALUES(?, ?, ?, ? ,? ,? ,?)";

        try(Connection connection = this.dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)){

            preparedStatement.setString(1, player.getName());
            preparedStatement.setString(2, player.getGender());
            preparedStatement.setInt(3, player.getLevel());
            preparedStatement.setInt(4, player.getExperience());
            preparedStatement.setInt(5, player.getPlayerHealth());
            preparedStatement.setInt(6, player.getPlayerRace().getRaceID());
            preparedStatement.setInt(7, player.getPlayableClass().getPlayableClassID());

            //If you do delete, an update, or an insert, you do this
            //no need for result set because those things don't give us back any rows
            int returnRow = preparedStatement.executeUpdate();
        }
        catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
    }
}
