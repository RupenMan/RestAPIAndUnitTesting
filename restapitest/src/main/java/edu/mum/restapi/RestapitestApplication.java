package edu.mum.restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("edu.mum.restapi.model")
public class RestapitestApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestapitestApplication.class, args);
	}
}
