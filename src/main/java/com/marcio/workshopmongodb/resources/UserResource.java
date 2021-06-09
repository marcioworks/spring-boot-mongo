package com.marcio.workshopmongodb.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marcio.workshopmongodb.entities.User;

@RestController
@RequestMapping("/users")
public class UserResource {

	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		User us1 = new User(1, "Marcio", "marcio@teste.com");
		User us2 = new User(1, "Maysa", "maysa@teste.com");
		List<User> users = new ArrayList<>();
		
		users.addAll(Arrays.asList(us1,us2));
		
		return ResponseEntity.ok().body(users);
	}
}
