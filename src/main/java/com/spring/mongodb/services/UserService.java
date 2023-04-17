package com.spring.mongodb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spring.mongodb.domain.User;
import com.spring.mongodb.repository.UserRepository;


@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	//find all
	public ResponseEntity<List<User>> findAll(){
		
		List<User> listUsers = userRepository.findAll();
		return ResponseEntity.ok().body(listUsers) ;
	}// 

}
