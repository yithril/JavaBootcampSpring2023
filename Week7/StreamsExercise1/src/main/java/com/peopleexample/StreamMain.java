package com.peopleexample;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {
        List<Person> personList = PersonGenerator.generateRandomPeople(10);

        //Find the number of people who are age 30 or over
        //declarative
        //long numberOfPeople = personList.stream().filter(person -> person.getAge() >= 30).count();
        //long numberOfPeopleImperative = getNumberOfPeopleOver30(personList);

        var numberOfPeopleInMichigan = personList.stream().filter(person -> person.getHomeState().equals("Michigan")).count();

        //People from Florida over the age of 65
        var floridaPeeps = personList.stream()
                .filter(person -> person.getHomeState().equals("Florida") && person.getAge() > 65)
                .count();

        //System.out.printf("Number of people in Florida over the age of 65: %d %n", floridaPeeps);

        //System.out.printf("There are %d people over the age of 30 %n", numberOfPeople);
       // System.out.printf("There are %d people over the age of 30 %n", numberOfPeopleImperative);

        //System.out.printf("There are %d people in Michigan", numberOfPeopleInMichigan);

        //What if I want a list of those people?
        //What if I wanted a list of people named "Bob"?
        List<Person> peopleNamedBob = personList.stream()
                .filter(person -> person.getFirstName().equals("Bob"))
                .collect(Collectors.toList());

        for(Person person : peopleNamedBob){
            //System.out.printf("First Name: %s Last Name: %s Age: %d State: %s %n",
                    //person.getFirstName(), person.getLastName(), person.getAge(), person.getHomeState());
        }

        //You are free from the drudgery of for loops
        personList.stream().forEach(person -> System.out.printf("Hi my name is %s %s, and I am from %s %n",
                                        person.getFirstName(), person.getLastName(), person.getHomeState()));


        //MAP
        List<Integer> ageList = personList.stream().
                map(person -> person.getAge()).collect(Collectors.toList());
        //System.out.println(ageList);

        //Person::getAge is called a method reference
        var totalAge = personList.stream().mapToInt(Person::getAge).sum();
        System.out.println("The sum of all the ages of people in this group is: " + totalAge);

        var averageAge = personList.stream().mapToInt(Person::getAge).average();
        System.out.println("The average age of the people in this list is :" + averageAge.orElse(0));
    }

    public static long getNumberOfPeopleOver30(List<Person> personList){
        //imperative
        int personOver30Count = 0;

        for(Person p : personList){
            if(p.getAge() >= 30){
                personOver30Count += 1;
            }
        }

        return personOver30Count;
    }
}
