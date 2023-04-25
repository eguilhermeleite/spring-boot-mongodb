package com.spring.mongodb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.spring.mongodb.domain.User;
import com.spring.mongodb.dto.UserDTO;
import com.spring.mongodb.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	

	@GetMapping
	public ResponseEntity<List<UserDTO>> all() {

		return userService.findAll();

	}

	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> byId(@PathVariable String id){
		return userService.findByIdDTO(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public User insert(@RequestBody User user) {
		return userService.insert(user);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id){
		return userService.delete(id);
	}

}
