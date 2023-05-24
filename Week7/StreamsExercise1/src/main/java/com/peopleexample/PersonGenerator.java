package com.peopleexample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PersonGenerator {
    private static Random random = new Random();
    public static List<Person> generateRandomPeople(int totalCount){
        List<Person> personList = new ArrayList<>();
        //I'm cutting it off at a 1000000 just in case anyone gets any ideas
        if(totalCount > 1000000){
            System.out.println("Sorry that's a bit too many for this example. Giving you an empty list.");
            return new ArrayList<>();
        }
        else{
            for(int i = 0; i < totalCount; i++){
                personList.add(new Person(getRandomFirstName(), getRandomLastName(), getRandomAge(), getRandomState()));
            }

            return personList;
        }
    }

    private static String getRandomState(){
        List<String> states = Arrays.asList("Alabama", "Alaska", "American Samoa", "Arizona", "Arkansas", "California", "Colorado", "Connecticut", "Delaware", "District of Columbia", "Florida", "Georgia", "Guam", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota", "Minor Outlying Islands", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Northern Mariana Islands", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Puerto Rico", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "U.S. Virgin Islands", "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming");

        return states.get(random.nextInt(states.size()));
    }

    private static int getRandomAge(){
        //we'll say max 100 years old
        return random.nextInt(99) + 1;
    }

    private static String getRandomFirstName(){
        List<String> firstNames = Arrays.asList("Steve", "George", "Joe", "Reginald", "Bob", "John", "Rashawn",
                "DeAndre", "Zach", "Tamiko", "Yosuke", "Narukami", "Kanji", "Naoto", "Sheila", "Amanda",
                "Neela", "Quisha", "Kayla", "Amelia", "Karen", "Hortence", "Penelope", "Hermione", "Yukiko",
                "Chie", "Yennefer", "Robert", "Clint", "Hans", "Bernhard", "Wolfgang", "Mareile", "Ignacio",
                "Lawrence", "Gabriel", "Logan", "Elizabeth", "Patricia", "Nancy", "Betty", "Sandra", "Ashley", "Kimberly",
                "Ahmed", "Diego", "Manuel", "Xingshuo", "Narasimhan", "Raj", "Nagalakshmi", "Harry", "Mildred", "Eufalia",
                "Gregory", "Martin", "Jonathan", "Silvia", "Marigold", "Heather", "Zena", "Ziva", "Jawuan");

        return firstNames.get(random.nextInt(firstNames.size()));
    }

    private static String getRandomLastName(){
        List<String> lastNames = Arrays.asList("Smith", "Johnson", "Williams", "Brown", "Jones", "Miller", "Davis", "Garcia",
                "Rodriguez", "Wilson", "Martinez", "Anderson", "Taylor", "Thomas", "Hernandez", "Moore",
                "Martin", "Jackson", "Thompson", "White", "Lopez", "Lee", "Gonzalez", "Harris", "Clark", "Robinson",
                "Walker", "Perez", "Hall", "Young", "Allen", "Torres", "Evans", "Schmidt", "Fischer", "Ludwig", "Werner",
                "Heinrich", "Khan", "Patel", "Wu", "Lu", "Kim", "Hope");

        return lastNames.get(random.nextInt(lastNames.size()));
    }
}
