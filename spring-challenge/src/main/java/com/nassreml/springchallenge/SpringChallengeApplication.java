package com.nassreml.springchallenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringChallengeApplication {

	public static void main(String[] args) {
		new AnnotationConfigApplicationContext(AppConfig.class);
		SpringApplication.run(SpringChallengeApplication.class, args);
	}

}
