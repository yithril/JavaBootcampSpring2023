package com.zork.models;

import com.zork.models.dao.PlayableClassDAO;
import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlayableClassTest {
    @Test
    public void getAllPlayableClasses_Succeeds(){
        //Arrange
        //We need the data source for the PlayableClassDAO
        BasicDataSource dataSource = new BasicDataSource();

        dataSource.setUrl("jdbc:mysql://localhost:3306/zork");
        dataSource.setUsername("root");
        dataSource.setPassword("Leeames123!");

        PlayableClassDAO dao = new PlayableClassDAO(dataSource);

        //Act
        List<PlayableClass> testList = dao.getPlayableClass();

        //Assert
        //I expect 3 playable classes to come back
        //I expect there to be a Paladin, Rogue, and Wizard
        assertEquals(3, testList.size());
    }
}