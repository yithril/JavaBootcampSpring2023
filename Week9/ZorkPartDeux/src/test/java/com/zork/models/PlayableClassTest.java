package com.zork.models;

import com.zork.models.dao.PlayableClassDAO;
import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class PlayableClassTest {
    private PlayableClassDAO playableClassDAO;

    @BeforeEach
    public void before(){
        BasicDataSource dataSource = new BasicDataSource();

        dataSource.setUrl("jdbc:mysql://localhost:3306/zork");
        dataSource.setUsername("root");
        dataSource.setPassword("Leeames123!");

        this.playableClassDAO = new PlayableClassDAO(dataSource);
    }

    @Test
    public void getAllPlayableClasses_Succeeds(){
        List<PlayableClass> testList = this.playableClassDAO.getPlayableClass();

        //Assert
        //I expect 3 playable classes to come back
        //I expect there to be a Paladin, Rogue, and Wizard
        assertEquals(3, testList.size());
    }

    @Test
    public void getPlayableClassById_Succeeds(){
        Optional<PlayableClass> result = this.playableClassDAO.getPlayableClassByID(1);

        assertEquals(true, result.isPresent());
    }

    @Test
    public void getPlayableClassByID_NoSuchID(){
        Optional<PlayableClass> result = this.playableClassDAO.getPlayableClassByID(10000);

        assertEquals(false, result.isPresent());
    }
}