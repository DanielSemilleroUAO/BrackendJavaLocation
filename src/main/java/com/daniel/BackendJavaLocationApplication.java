package com.daniel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class BackendJavaLocationApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendJavaLocationApplication.class, args);
	}

}
