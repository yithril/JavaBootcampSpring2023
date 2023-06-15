package com.zork.models.dao;

import com.zork.models.Race;

import javax.sql.DataSource;
import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RaceDAO {
    private DataSource dataSource;

    public RaceDAO(DataSource dataSource){
        this.dataSource = dataSource;
    }

    //CRUD functions

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

    //get race by its id
    public Optional<Race> getRaceByID(int id){
        String query = "SELECT * FROM race WHERE raceID = ?";
        Race race = null;

        try(Connection connection = this.dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)){

            preparedStatement.setInt(1, id);

            try(ResultSet result = preparedStatement.executeQuery()){
                while(result.next()){
                    race = new Race(
                            result.getString("name"),
                            result.getString("homeland"),
                            result.getInt("healthBoost"),
                            result.getInt("magicBoost"),
                            result.getDouble("regenRate"),
                            result.getInt("raceID")
                    );
                }
            }
        }
        catch (SQLException sqlException){
            sqlException.printStackTrace();
        }

        return Optional.ofNullable(race);
    }

    //Delete a singular race
    //Delete a singular row
    public void deleteRace(int id){
        String query = "DELETE from race WHERE raceID = ?";

        try(Connection connection = this.dataSource.getConnection();
           PreparedStatement preparedStatement = connection.prepareStatement(query)){

            preparedStatement.setInt(1, id);

            int rows = preparedStatement.executeUpdate();
        }
        catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
    }

    //CREATE
    public void createRace(Race race){
        //Write query
        String query = "INSERT INTO race (name, homeland, healthBoost, magicBoost, regenRate)" +
                       "VALUES(?, ?, ?, ?, ?)";

        //Connect to database - Prepared Statement
        try(Connection connection = this.dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)){

            preparedStatement.setString(1, race.getName());
            preparedStatement.setString(2, race.getHomeland());
            preparedStatement.setInt(3, race.getHealthBoost());
            preparedStatement.setInt(4, race.getMagicBoost());
            preparedStatement.setDouble(5, race.getRegenRate());

            //Execute query
            int rows = preparedStatement.executeUpdate();
        }
        //Catch any errors
        catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
    }

    //UPDATE
    //We have decided to just allow them to update homeland and that's it
    public void updateRace(Race race){
        String query = "UPDATE race SET homeland = ? WHERE raceID = ?";

        try(Connection connection = this.dataSource.getConnection();
           PreparedStatement preparedStatement = connection.prepareStatement(query)){

            preparedStatement.setString(1, race.getHomeland());
            preparedStatement.setInt(2, race.getRaceID());

            int rows = preparedStatement.executeUpdate();
        }
        catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
    }
}
