package com.marcio.workshopmongodb.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marcio.workshopmongodb.entities.User;
import com.marcio.workshopmongodb.services.UserService;

@RestController
@RequestMapping("/users")
public class UserResource {
	
	@Autowired
	private UserService service;

	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		
		List<User> users = service.findAll();
			
		return ResponseEntity.ok().body(users);
	}
}
