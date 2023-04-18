package com.spring.mongodb.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spring.mongodb.domain.User;
import com.spring.mongodb.dto.UserDTO;
import com.spring.mongodb.repository.UserRepository;


@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	//find all
	public ResponseEntity<List<UserDTO>> findAll(){
		
		List<User> listUsers = userRepository.findAll();
		List<UserDTO> listUsersDTO = listUsers.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listUsersDTO) ;
	}// 

}
