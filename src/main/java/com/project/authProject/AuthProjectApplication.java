package com.project.authProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AuthProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthProjectApplication.class, args);
		System.out.println("Server started on port 8080");
	}

}
