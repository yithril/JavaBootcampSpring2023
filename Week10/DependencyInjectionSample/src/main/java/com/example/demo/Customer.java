package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

//The @Component annotation is applied to a class
@Component
public class Customer {
    private String fullName;

    //The Bean annotation is applied to a method
    @Bean
    public String getFullName(){
        return "Steve Rogers";
    }
}
