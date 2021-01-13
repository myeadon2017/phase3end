package com.phase3end.phase3end;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.phase3end")
@EnableJpaRepositories(basePackages = "com")
@EntityScan(basePackages = "com")
public class Phase3endApplication {

	public static void main(String[] args) {
		SpringApplication.run(Phase3endApplication.class, args);
	}

}
