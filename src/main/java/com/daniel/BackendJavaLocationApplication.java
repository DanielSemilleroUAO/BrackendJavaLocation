package com.daniel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@OpenAPIDefinition
@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class BackendJavaLocationApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendJavaLocationApplication.class, args);
	}

}
