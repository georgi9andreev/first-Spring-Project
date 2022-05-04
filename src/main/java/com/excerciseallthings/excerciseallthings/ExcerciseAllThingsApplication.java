package com.excerciseallthings.excerciseallthings;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication (exclude = {SecurityAutoConfiguration.class})
public class ExcerciseAllThingsApplication {

	//Така го регистрираме в Spring контейнера и можем да го викаме с
	// Autowired от всякъде вече
		@Bean
		public BCryptPasswordEncoder bCryptPasswordEncoder(){
			return new BCryptPasswordEncoder();
		}

	public static void main(String[] args) {
		SpringApplication.run(ExcerciseAllThingsApplication.class, args);
	}

}
