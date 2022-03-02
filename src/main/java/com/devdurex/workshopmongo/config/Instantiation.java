package com.devdurex.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.devdurex.workshopmongo.domain.Post;
import com.devdurex.workshopmongo.domain.User;
import com.devdurex.workshopmongo.repository.PostRepository;
import com.devdurex.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User schummacher = new User(null, "Schumacher", "schumi@gmail.com");
		User barrichello = new User(null, "Rubens Barrichello", "barrica@gmail.com");
		User massa = new User(null, "Felipe Massa", "massa@gmail.com");
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo", massa);
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Happy day today", barrichello);
		
				
		userRepository.saveAll(Arrays.asList(schummacher, barrichello, massa));
		postRepository.saveAll(Arrays.asList(post1, post2));
		
	}

}
