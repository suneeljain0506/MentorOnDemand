package com.lnt.infotech.admin;

import com.lnt.infotech.admin.entities.Skills;
import com.lnt.infotech.admin.entities.TrainerDetails;
import com.lnt.infotech.admin.entities.Users;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class AdminApplication {

	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(AdminApplication.class, args);
	}

	@Bean
	public CommandLineRunner demoData(SkillsRepository repo,TrainerDetailsRepository tdr,UserRepository ur) {
		return args -> {
			Skills skills = new Skills("na");
			repo.save(skills);
			Users users = new Users();
			TrainerDetails trainerDetails = new TrainerDetails();
			trainerDetails.setEmail("a@a");
			tdr.save(trainerDetails);
			users.setEmail("a@a");
			users.setPassword("a");
			users.setRole("admin");
			users.setUserName("ADMIN");
			users.setTrainerDetails(trainerDetails);
//			repo.save(new Entity(...));
			ur.save(users);
		};
	}

}
