package com.zork.view;

import com.zork.controllers.RaceController;
import com.zork.models.Race;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayerCreation {
    private RaceController raceController;

    public PlayerCreation(RaceController raceController){
        this.raceController = raceController;
    }
    public void characterCreateScreen(){
        Scanner scanner = new Scanner(System.in);

        boolean creatingCharacter = true;

        while(creatingCharacter){
            System.out.println("Please select from the following options:");
            displayCharacterCreationMenu();
            int userInput = scanner.nextInt();

            switch(userInput){
                case 1:
                    //Display the list of races
                    List<Race> races = this.raceController.getAllRaces();

                    for(Race race : races){
                        System.out.println(race.getRaceID());
                        System.out.println(race.getName());
                    }
                    break;
                default:
                    System.out.println("Smell ya later!");
                    System.exit(1);
            }
        }
    }
    private void displayCharacterCreationMenu(){
        System.out.println("1. Pick Race");
        System.out.println("2. Pick Class");
        System.out.println("3. Select Gender");
        System.out.println("4. Select Age");
        System.out.println("5. Name");
        System.out.println("6. Quit");
    }
}
