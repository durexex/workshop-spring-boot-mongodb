package com.devdurex.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.devdurex.workshopmongo.domain.User;
import com.devdurex.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		User schummacher = new User(null, "Schumacher", "schumi@gmail.com");
		User barrichello = new User(null, "Rubens Barrichello", "barrica@gmail.com");
		User massa = new User(null, "Felipe Massa", "massa@gmail.com");
		
		userRepository.saveAll(Arrays.asList(schummacher, barrichello, massa));
		
	}

}
