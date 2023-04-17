package com.spring.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.spring.mongodb.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}
