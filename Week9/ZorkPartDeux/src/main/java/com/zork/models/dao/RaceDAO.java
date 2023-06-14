package com.zork.models.dao;

import com.zork.models.Race;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RaceDAO {
    private DataSource dataSource;

    public RaceDAO(DataSource dataSource){
        this.dataSource = dataSource;
    }

    //method to get all races
    public List<Race> getAllRaces(){
        List<Race> returnList = new ArrayList<>();

        String query = "SELECT * FROM race";

        try(Connection connection = this.dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)){

            try(ResultSet result = preparedStatement.executeQuery()){
                while(result.next()){
                    Race race = new Race(
                            result.getString("name"),
                            result.getString("homeland"),
                            result.getInt("healthBoost"),
                            result.getInt("magicBoost"),
                            result.getDouble("regenRate"),
                            result.getInt("raceID")
                    );

                    returnList.add(race);
                }
            }
        }
        catch(SQLException exception){
            exception.printStackTrace();
        }

        return returnList;
    }
}
