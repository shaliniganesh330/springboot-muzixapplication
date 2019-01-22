package com.stackroute;

import com.stackroute.domain.User;
import com.stackroute.repository.MuzixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

@SpringBootApplication
public class MuzixApplication implements ApplicationListener<ContextRefreshedEvent>, CommandLineRunner {

	@Autowired
	MuzixRepository muzixRepository;
	public static void main(String[] args) {
		SpringApplication.run(MuzixApplication.class, args);
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
		muzixRepository.save(new User(1,"Happy Days","with family"));
	}

	@Override
	public void run(String... args) throws Exception {
		muzixRepository.save(new User(2,"Work","Work is Worship"));
	}
}
