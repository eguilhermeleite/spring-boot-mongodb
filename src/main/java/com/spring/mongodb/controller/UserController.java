package com.spring.mongodb.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.mongodb.domain.User;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@GetMapping
	public ResponseEntity<List<User>> all(){
		
		User u1 = new User(1L, "Mary Green", "mary@gmail.com");
		User u2 = new User(2L, "Alex Brown", "alex@gmail.com");
		User u3 = new User(3L, "Jonh Deer", "john@gmail.com");
		
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(u1,u2,u3));
		
		return ResponseEntity.ok().body(list) ;
	}

}
