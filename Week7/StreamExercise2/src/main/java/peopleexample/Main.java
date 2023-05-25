package peopleexample;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main2(String[] args) {
         List<Integer> numberList = Arrays.asList(5, 10, 9, 2, 3, 1, 2, 10);

         List<Integer> mappedList = numberList.stream()
                                        .map(num -> num * 2)
                                        .collect(Collectors.toList());

        //System.out.println("Original list: " + numberList);
        //System.out.println("Mapped list: " + mappedList);

        List<String> stringList = Arrays.asList("Bob", "Joe", "Mary", "Sue");

        List<String> mappedStringList = stringList.stream()
                                            .map(str -> str.toUpperCase())
                                            .collect(Collectors.toList());

        //System.out.println(mappedStringList);

        List<Integer> listToReduce = Arrays.asList(20, 120, 2, 225, 700, 5);

        var result = listToReduce.stream().reduce(0, (sum, num) -> sum += num);

        System.out.println(result);

        List<String> stringToReduce = Arrays.asList("Strawberry", "Orange", "Banana", "Grapefruit");

        //var result2 = stringToReduce.stream().reduce((res, next) -> res += next).orElse("");

        //System.out.println(result2);
    }

    //For example [2, 5, 10, 12] how would you get sum with a for loop?
    public static int sumOfArray(List<Integer> integerList){
        int sum = 0;

        //Type variable : list
        for(Integer num : integerList){
            sum += num;
        }

        return sum;
    }
}
