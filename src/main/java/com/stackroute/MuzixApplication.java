package com.stackroute;

import com.stackroute.domain.User;
import com.stackroute.repository.MuzixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.Environment;

@SpringBootApplication
@PropertySource("classpath:property.properties")
public class MuzixApplication implements ApplicationListener<ContextRefreshedEvent>,CommandLineRunner {
	//by using @Value application property//
	@Value("4")
	private int trackId;
//	@Value("shalini")
	// by using @property//
	@Value("${trackName}")
	private String trackName;
	@Value("Good Bye")
	private String trackComments;

	@Autowired
	MuzixRepository muzixRepository;
	@Autowired
	Environment env;

	public static void main(String[] args) {
		SpringApplication.run(MuzixApplication.class, args);
	}
	@Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
		muzixRepository.save(new User(trackId,trackName,trackComments));
	}
//	@Override
//	public void run(String... args) throws Exception {
//		muzixRepository.save(new User(trackId,trackName,trackComments));
//	}
	//CommandLineRunner//
	@Override
	public void run(String...args)throws Exception{
		muzixRepository.save(new User(Integer.parseInt(env.getProperty("trackId")),env.getProperty("trackName"),env.getProperty("trackComments")));
	}
}
