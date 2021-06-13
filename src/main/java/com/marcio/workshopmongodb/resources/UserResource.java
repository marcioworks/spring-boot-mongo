package com.marcio.workshopmongodb.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.marcio.workshopmongodb.dto.UserDto;
import com.marcio.workshopmongodb.entities.User;
import com.marcio.workshopmongodb.services.UserService;

@RestController
@RequestMapping("/users")
public class UserResource {
	
	@Autowired
	private UserService service;

	@GetMapping
	public ResponseEntity<List<UserDto>> findAll(){
		
		List<User> users = service.findAll();
		List<UserDto> listDto = users.stream().map(x -> new UserDto(x)).collect(Collectors.toList());
			
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<UserDto> findById(@PathVariable String id){
		
		User user = service.findById(id);
			
		return ResponseEntity.ok().body(new UserDto(user));
	}
}
