package com.avijit.sharedrive;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SharedriveApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.configure().load();
		SpringApplication.run(SharedriveApplication.class, args);
	}

}
