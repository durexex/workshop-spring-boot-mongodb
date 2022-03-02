package com.devdurex.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devdurex.workshopmongo.domain.User;
import com.devdurex.workshopmongo.dto.UserDTO;
import com.devdurex.workshopmongo.repository.UserRepository;
import com.devdurex.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll() {
		return repo.findAll();		
	}

	
	public User findbyId(String id) {
		//User user = repo.findOne(id);
		Optional<User> user = repo.findById(id);
		if (user == null) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		
		return user.get();		
	}	
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
}
