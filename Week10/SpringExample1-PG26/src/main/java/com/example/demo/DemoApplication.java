package com.example.demo;

import com.example.demo.exception.StudentAlreadyRegisteredException;
import com.example.demo.models.Student;
import com.example.demo.service.RegistrationService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);

		for(String bean : ctx.getBeanDefinitionNames()) {
			System.out.println(bean);
		}

		//Notice how we do not have to create a DAO to put into RegisterService
		//Spring's IOC container does it for us.
		RegistrationService registrationService = ctx.getBean(RegistrationService.class);

		try{
			Long studentID = registrationService.registerStudent(
					new Student("Alan", "Turing", "Computer Science"));
			System.out.println("Student Registered with ID: "
					+ studentID);
			Long studentID2 = registrationService.registerStudent(
					new Student("Johannes", "Kepler", "Astronomy"));
			System.out.println("Student Registered with ID: "
					+ studentID2);
		}
		catch(StudentAlreadyRegisteredException ex){
			ex.printStackTrace();
		}
	}

}
