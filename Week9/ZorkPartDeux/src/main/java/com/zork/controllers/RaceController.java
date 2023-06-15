package com.zork.controllers;

import com.zork.models.Race;
import com.zork.models.dao.RaceDAO;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class RaceController {
    //dependencies
    private DataSource dataSource;
    private RaceDAO raceDAO;

    public RaceController(DataSource dataSource){
        this.dataSource = dataSource;
        this.raceDAO = new RaceDAO(dataSource);
    }

    public List<Race> getAllRaces(){
        return this.raceDAO.getAllRaces();
    }

    public Optional<Race> getRaceByID(int id){
        return this.raceDAO.getRaceByID(id);
    }
}
