package com.ai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringAiDemoApplication {

	public static void main(String[] args) {
		EnvLoader.loadEnv(); // Load .env values
		SpringApplication.run(SpringAiDemoApplication.class, args);
	}

}
