package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);

		for(String bean : context.getBeanDefinitionNames()) {
			System.out.println(bean);
		}

		//This will give me an instance of class
		//Why? Because we put the @Component annotation above the class
		//Without it, the Spring IOC container has no idea it exists.
		Customer customerClassBean = context.getBean(Customer.class);

		//We can also get the return value of a method if we used the @Bean annotation
		var getName = context.getBean("getFullName", String.class);

		System.out.println(getName);
	}

}
