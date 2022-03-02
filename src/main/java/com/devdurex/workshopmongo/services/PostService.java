package com.devdurex.workshopmongo.services;

import java.util.Date;
import java.util.List;
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
	
	public List<Post> findByTitle(String text) {
		return repo.searchTitle(text);
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
		return repo.fullSearch(text, minDate, maxDate);
	}
	

}
