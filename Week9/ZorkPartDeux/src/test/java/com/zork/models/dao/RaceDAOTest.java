package com.zork.models.dao;

import com.zork.models.Race;
import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;

class RaceDAOTest {
    @Test
    public void getAllRaces_Succeeds(){

        BasicDataSource dataSource = new BasicDataSource();

        dataSource.setUrl("jdbc:mysql://localhost:3306/zork");
        dataSource.setUsername("root");
        dataSource.setPassword("Leeames123!");

        RaceDAO raceDao = new RaceDAO(dataSource);
        List<Race> testList = raceDao.getAllRaces();

        //Assert
        assertEquals(3, testList.size());
    }
}