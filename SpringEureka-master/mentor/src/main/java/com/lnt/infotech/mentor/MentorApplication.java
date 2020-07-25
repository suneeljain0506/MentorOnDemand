package com.lnt.infotech.mentor;

import com.lnt.infotech.mentor.entities.Skills;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class MentorApplication {

	public static void main(String[] args) {
		SpringApplication.run(MentorApplication.class, args);
	}

	@Bean
	public CommandLineRunner demoData(SkillsRepository repo) {
		return args -> {
			Skills skills = new Skills("other");
			repo.save(skills);
//			repo.save(new Entity(...));
		};
	}

}
