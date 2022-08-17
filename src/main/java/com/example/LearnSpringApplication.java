package com.example;

import com.example.entity.Student;
import com.example.repository.StudentRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class LearnSpringApplication {

	public static void main(String[] args) {
	    ApplicationContext applicationContext=SpringApplication.run(LearnSpringApplication.class, args);
		System.out.println("......................................................................Application is " +
				"Running..................................................................");

	}

}


