package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.example.demo"})
public class ProjectXV1Application {

	public static void main(String[] args) {
		SpringApplication.run(ProjectXV1Application.class, args);
	}

}
