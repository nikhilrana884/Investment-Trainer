package io.MiniProject.Investment.Trainer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class InvestmentTrainerApplication {

	public static void main(String[] args) {
		SpringApplication.run(InvestmentTrainerApplication.class, args);
	}

}
