package com.marcio.workshopmongodb.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.marcio.workshopmongodb.entities.User;

@Repository
public interface UserRespository extends MongoRepository<User, String> {

}
