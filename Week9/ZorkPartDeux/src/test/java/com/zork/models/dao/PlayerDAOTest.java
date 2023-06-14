package com.zork.models.dao;

import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.zork.models.*;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class PlayerDAOTest {
    private PlayerDAO playerDAO;
    private RaceDAO raceDAO;
    private PlayableClassDAO playableClassDAO;
    @BeforeEach
    public void before(){
        BasicDataSource dataSource = new BasicDataSource();

        dataSource.setUrl("jdbc:mysql://localhost:3306/zork");
        dataSource.setUsername("root");
        dataSource.setPassword("Leeames123!");

        this.playerDAO = new PlayerDAO(dataSource);
        this.raceDAO = new RaceDAO(dataSource);
        this.playableClassDAO = new PlayableClassDAO(dataSource);
    }
    @Test
    public void createNewPlayer_Succeeds(){
        //Arrange
        Optional<Race> race = this.raceDAO.getRaceByID(1);
        Optional<PlayableClass> playableClass = this.playableClassDAO.getPlayableClassByID(1);

        //A fake player we'll probably never use
        //I just wanna see if it gets saved to SQL
        Player player = new Player();
        player.setName("Harpoon");
        player.setAge(1000);
        player.setPlayerHealth(50);
        player.setGender("Male");
        player.setLevel(49);
        player.setExperience(10000);
        player.setPlayerRace(race.get());
        player.setPlayableClass(playableClass.get());

        //Act
        this.playerDAO.createPlayer(player);

        //Assert
    }

}