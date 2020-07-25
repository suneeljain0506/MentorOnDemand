package com.lnt.infotech.user;

import com.lnt.infotech.user.entities.Skills;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class UserApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}

	@Bean
	public CommandLineRunner demoData(SkillsRepository repo) {
		return args -> {
			Skills skills = new Skills("na");
			repo.save(skills);
//			repo.save(new Entity(...));
		};
	}

}
