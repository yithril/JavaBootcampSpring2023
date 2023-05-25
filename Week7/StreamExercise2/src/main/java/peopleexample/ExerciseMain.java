package peopleexample;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ExerciseMain {
    public static void main(String[] args) {
        List<Person> personList = PersonGenerator.generateRandomPeople(10000);

        var averageAge = personList.stream().mapToInt(Person::getAge).average().orElse(0);

        var averageAgeWithReduce = personList.stream()
                                    .map(person -> person.getAge())
                                    .reduce(0, (res, next) -> res += next) / personList.size();

        System.out.println("Hey there whatsup!");
    }

    //ArrayList::new is a method reference
    public static List<Person> findPersonByName(String name, List<Person> peopleList){
        return peopleList.stream().filter(person -> person.getFirstName().equals(name))
                .collect(Collectors.toList());
    }


}
