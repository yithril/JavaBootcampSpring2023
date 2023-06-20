package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ClassexampleApplication {

	public static void main(String[] args) throws StudentAlreadyRegisteredException {
		ConfigurableApplicationContext ctx = SpringApplication.run(ClassexampleApplication.class, args);

		for(String bean : ctx.getBeanDefinitionNames()) {
			System.out.println(bean);
		}

		RegistrationService registrationService =
				ctx.getBean(RegistrationService.class);

		Long studentID = registrationService.registerStudent(
				new Student("Alan", "Turing", "Computer Science"));
		System.out.println("Student Registered with ID: "
				+ studentID);
		Long studentID2 = registrationService.registerStudent(
				new Student("Johannes", "Kepler", "Astronomy"));
		System.out.println("Student Registered with ID: "
				+ studentID2);
	}

}
