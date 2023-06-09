package com.zork.models.dao;

import com.zork.models.PlayableClass;
import com.zork.models.Race;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//This class is responsible for working with SQL
//specifically, with the playableClass table
public class PlayableClassDAO {
    private DataSource dataSource;
    public PlayableClassDAO(DataSource dataSource){
        this.dataSource = dataSource;
    }
    public List<PlayableClass> getPlayableClass(){
        //this list will hold everything I get back from SQL
        List<PlayableClass> playableClassList = new ArrayList<>();

        //Write the query
        String query = "SELECT * FROM playableClass";

        //using statement
        //try with
        try(Connection connection = this.dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);){

            //Result Set
            try(ResultSet result = preparedStatement.executeQuery();){
                //Loop through every row that SQL gave back to us
                while(result.next()){
                    PlayableClass pc = new PlayableClass(
                            result.getInt("healthBoost"),
                            result.getInt("magicBoost"),
                            result.getInt("damageBoost"),
                            result.getString("name"),
                            result.getInt("playableClassID")
                    );

                    playableClassList.add(pc);
                }
            }
        }
        catch(SQLException exception){
            exception.printStackTrace();
        }

        return playableClassList;
    }

    public Optional<PlayableClass> getPlayableClassByID(int id){
        String query = "SELECT * FROM playableClass WHERE playableClassID = ?";
        PlayableClass playableClass = null;

        try(Connection connection = this.dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)){

            preparedStatement.setInt(1, id);

            try(ResultSet result = preparedStatement.executeQuery()){
                while(result.next()){
                    playableClass = new PlayableClass(
                            result.getInt("healthBoost"),
                            result.getInt("magicBoost"),
                            result.getInt("damageBoost"),
                            result.getString("name"),
                            result.getInt("playableClassID")
                    );
                }
            }
        }
        catch (SQLException sqlException){
            sqlException.printStackTrace();
        }

        return Optional.ofNullable(playableClass);
    }
}
