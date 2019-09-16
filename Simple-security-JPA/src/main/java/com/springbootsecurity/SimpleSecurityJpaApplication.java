package com.springbootsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.springbootsecurity.repository.UserRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class SimpleSecurityJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleSecurityJpaApplication.class, args);
	}

}
