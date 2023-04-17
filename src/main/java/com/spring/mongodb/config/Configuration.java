package com.spring.mongodb.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.spring.mongodb.domain.User;
import com.spring.mongodb.repository.UserRepository;

@org.springframework.context.annotation.Configuration
public class Configuration implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {

		userRepository.deleteAll();

		User maria = new User(null, "Maria da Silva", "madasilva@gmail.com");
		User joão = new User(null, "João de Barros", "jdb@gmail.com");
		User felipe = new User(null, "Felipe Honorato", "fehonorato@gmail.com");
		User douglas = new User(null, "Douglas Mathias", "dougmathias@gmail.com");

		userRepository.saveAll(Arrays.asList(maria, joão, felipe, douglas));
	}
}
