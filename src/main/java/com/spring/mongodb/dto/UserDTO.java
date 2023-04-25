package com.spring.mongodb.dto;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.spring.mongodb.domain.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private String email;
	
	public UserDTO(User obj) {
		id = obj.getId();
		name = obj.getName();
		email = obj.getEmail();
	}

	public UserDTO(ResponseEntity<User> user) {
		id = user.getBody().getId();
		name = user.getBody().getName();
		email = user.getBody().getEmail();
	}

	

}
