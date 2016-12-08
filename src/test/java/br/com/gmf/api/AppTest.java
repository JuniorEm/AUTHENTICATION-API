package br.com.gmf.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.ActiveProfiles;

@SpringBootApplication
@ActiveProfiles("test")
public class AppTest {
	
	public static void main(String... args) {
		SpringApplication.run(AppTest.class, args);
	}

}
