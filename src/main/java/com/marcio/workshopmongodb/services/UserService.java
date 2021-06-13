package com.marcio.workshopmongodb.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcio.workshopmongodb.dto.UserDto;
import com.marcio.workshopmongodb.entities.User;
import com.marcio.workshopmongodb.repositories.UserRespository;
import com.marcio.workshopmongodb.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRespository repo;

	public List<User> findAll() {
		return repo.findAll();
	}

	public User findById(String id) {
		Optional<User> user = repo.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Usuario não encontrado"));
	}

	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public User update(User obj) {
		User newUser = findById(obj.getId());
		UpdateData(newUser,obj);
		return repo.save(newUser);
	}
	
	

	private void UpdateData(User newUser, User obj) {
		newUser.setName(obj.getName());
		newUser.setEmail(obj.getEmail());
	}

	public User fromDto(UserDto obj) {
		return new User(obj.getId(), obj.getName(), obj.getEmail());
	}
}
