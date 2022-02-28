package com.devdurex.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devdurex.workshopmongo.domain.User;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		User maria = new User("1", "Mariia Silva","maria@gmail.com");
		User leia = new User("2", "Leia Silva","leia@gmail.com");
		List<User> list = new ArrayList<>();
	
		list.addAll(Arrays.asList(maria, leia));
		
		return ResponseEntity.ok().body(list);
	}

}
