package com.group;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class RoleBasedGroupServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoleBasedGroupServiceApplication.class, args);
	}

}
