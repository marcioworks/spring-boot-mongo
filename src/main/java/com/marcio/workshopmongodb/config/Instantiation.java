package com.marcio.workshopmongodb.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.marcio.workshopmongodb.entities.User;
import com.marcio.workshopmongodb.repositories.UserRespository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRespository userRepository;

	@Override
	public void run(String... args) throws Exception {

		userRepository.deleteAll();
		// TODO Auto-generated method stub
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");

		userRepository.saveAll(Arrays.asList(maria, alex, bob));
	}

}
