package com.spring.mongodb.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spring.mongodb.domain.User;
import com.spring.mongodb.dto.UserDTO;
import com.spring.mongodb.exceptions.NullPointerException;
import com.spring.mongodb.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	// find all
	public ResponseEntity<List<UserDTO>> findAll() {

		List<User> listUsers = userRepository.findAll();
		List<UserDTO> listUsersDTO = listUsers.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());

		return ResponseEntity.ok().body(listUsersDTO);
	}//

	// findById
	public ResponseEntity<User> findById(String id) {
		String msg = "Resource Not Found";

		if (!userRepository.existsById(id)) {
			throw new NullPointerException(msg);
		}
		return userRepository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}//

	// retorna um user pelo id e o converte para userDTO
	public ResponseEntity<UserDTO> findByIdDTO(String id) {

		ResponseEntity<User> user = findById(id);
		UserDTO userDTO = new UserDTO(user.getBody());

		return ResponseEntity.ok().body(userDTO);

	}//

	// insert user
	public User insert(User user) {
		return userRepository.insert(user);
	}//

	public User fromDTO(UserDTO userDTO) {
		return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
	}
}
