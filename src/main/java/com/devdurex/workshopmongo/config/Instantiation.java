package com.devdurex.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.devdurex.workshopmongo.domain.Post;
import com.devdurex.workshopmongo.domain.User;
import com.devdurex.workshopmongo.dto.AuthorDTO;
import com.devdurex.workshopmongo.dto.CommentDTO;
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
		
		userRepository.saveAll(Arrays.asList(schummacher, barrichello, massa));
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo", new AuthorDTO(massa));
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Happy day today", new AuthorDTO(barrichello));
				
		CommentDTO c1 = new CommentDTO("Boa viagem", sdf.parse("21/03/2018"), new AuthorDTO(barrichello));
		CommentDTO c2 = new CommentDTO("Aproveita", sdf.parse("22/03/2018"), new AuthorDTO(schummacher));
		CommentDTO c3 = new CommentDTO("Tenho um bom dia", sdf.parse("23/03/2018"), new AuthorDTO(schummacher));
				
		post1.getComments().addAll(Arrays.asList(c1, c2));
		post2.getComments().addAll(Arrays.asList(c3));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		massa.getPosts().addAll(Arrays.asList(post1));
		userRepository.save(massa);		
		barrichello.getPosts().addAll(Arrays.asList(post2));
		userRepository.save(barrichello);
	}

}
