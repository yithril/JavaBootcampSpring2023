package com.peopleexample;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Example usage, generate 10000 random people
        List<Person> personList = PersonGenerator.generateRandomPeople(10);

        Scanner scanner = new Scanner(System.in);

        System.out.println("What is the first name of the person you're looking for?");

        String userInput = scanner.nextLine();

        ArrayList<Person> peopleWeFound = searchForPerson(userInput, personList);

        System.out.printf("I found %d people named %s", peopleWeFound.size(), userInput);
    }

    public static ArrayList<Person> searchForPerson(String firstName, List<Person> personsList){
        //placeholder
        ArrayList<Person> returnList = new ArrayList<>();

        //loop through all the people
        for(Person find : personsList){
            //Does their first name match the name the user put in?
            if(find.getFirstName().equalsIgnoreCase(firstName)){
                //if so, add the person to the list
                returnList.add(find);
            }
        }

        //return the list
        return returnList;
    }
}
