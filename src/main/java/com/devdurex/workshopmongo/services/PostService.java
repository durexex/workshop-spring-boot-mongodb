package com.devdurex.workshopmongo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devdurex.workshopmongo.domain.Post;
import com.devdurex.workshopmongo.repository.PostRepository;
import com.devdurex.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repo;
	
	
	public Post findbyId(String id) {
		//User user = repo.findOne(id);
		Optional<Post> post = repo.findById(id);
		if (post== null) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		
		return post.get();		
	}	
	
	
}