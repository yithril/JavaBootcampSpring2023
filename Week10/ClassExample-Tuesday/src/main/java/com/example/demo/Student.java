package com.example.demo;

import lombok.*;
import org.springframework.stereotype.Component;

//Annotations
//The @Component annotation goes with classes
@Component
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private long id;
    private String firstName;
    private String lastName;
    private String major;

    public Student(String firstName, String lastName, String major){
        this.firstName = firstName;
        this.lastName = lastName;
        this.major = major;
    }

    public String sayHello(){
        return "Hi there!";
    }
}
