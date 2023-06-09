package com.zork.models.dao;

import com.zork.models.Race;
import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Optional;


import static org.junit.jupiter.api.Assertions.*;

class RaceDAOTest {
    private RaceDAO raceDAO;

    @BeforeEach
    public void before(){
        BasicDataSource dataSource = new BasicDataSource();

        dataSource.setUrl("jdbc:mysql://localhost:3306/zork");
        dataSource.setUsername("root");
        dataSource.setPassword("Leeames123!");

        this.raceDAO = new RaceDAO(dataSource);
    }

    @Test
    public void getAllRaces_Succeeds(){
        List<Race> testList = this.raceDAO.getAllRaces();

        //Assert
        assertEquals(3, testList.size());
    }

    @Test
    public void getRaceById_Succeeds(){
        Optional<Race> result = this.raceDAO.getRaceByID(1);

        assertEquals(true, result.isPresent());
    }

    @Test
    public void getRaceByID_NoSuchID(){
        Optional<Race> result = this.raceDAO.getRaceByID(10000000);

        assertEquals(false, result.isPresent());
    }

    @Test
    public void deleteRace_Succeeds(){
        this.raceDAO.deleteRace(4);
    }

    @Test
    public void createRace_Succeeds(){
        //The id wont matter because it's not in the insert staement anyway
        Race race = new Race("Angel", "Heaven", 50, 50, .8, 1);

        this.raceDAO.createRace(race);
    }

    @Test
    public void updateRace_Homeland_Succeeds(){
        Race race = new Race("Angel", "Mordor", 50, 50, .8, 1);

        this.raceDAO.updateRace(race);
    }
}