package com.zork;

import com.zork.controllers.RaceController;
import com.zork.view.PlayerCreation;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;

public class Main {
    public static void main(String[] args) {
        if(args.length != 2){
            System.out.println("Username and password is required");
            System.exit(1);
        }

        String userName = args[0];
        String password = args[1];

        DataSource source = getDataSource(userName, password);
        RaceController raceController = new RaceController(source);

        PlayerCreation playerCreation = new PlayerCreation(raceController);

        playerCreation.characterCreateScreen();
    }

    private static BasicDataSource getDataSource(String userName, String password){
        BasicDataSource dataSource = new BasicDataSource();

        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        dataSource.setUrl("jdbc:mysql://localhost:3306/zork");

        return dataSource;
    }
}
