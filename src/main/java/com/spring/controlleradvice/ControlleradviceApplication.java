package com.spring.controlleradvice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
		info = @Info(
				title = "Springboot-Controller_Advice-Application",
				version = "1.0",
				description = "This project demonstrates how to use @ControllerAdvice in a Spring Boot application to globally handle exceptions and provide better exception management.",
//				termsOfService = "https://www.example.com/terms", // Link to terms of service
				contact = @Contact(
						name = "Varun Kadam",
						email = "kadamvarun94@gmail.com"
				),
				license = @License(
						name = "MIT license",
						url = "https://github.com/varun29802/spring_ControllerAdvice?tab=MIT-1-ov-file#readme"
				)
		),
		servers = {
				@Server(url = "http://127.0.0.1:8080/", description = "Local server"),
//				@Server(url = "https://staging.example.com/v1", description = "Staging server")
		}
)

//http://localhost:8080/swagger-ui/index.html
@SpringBootApplication
public class ControlleradviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControlleradviceApplication.class, args);
	}

}
