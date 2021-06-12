package com.marcio.workshopmongodb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcio.workshopmongodb.entities.User;
import com.marcio.workshopmongodb.repositories.UserRespository;

@Service
public class UserService {

	@Autowired
	private UserRespository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
}
