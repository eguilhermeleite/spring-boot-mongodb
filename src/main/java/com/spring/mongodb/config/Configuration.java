package com.spring.mongodb.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.spring.mongodb.domain.Post;
import com.spring.mongodb.domain.User;
import com.spring.mongodb.repository.PostRepository;
import com.spring.mongodb.repository.UserRepository;

@org.springframework.context.annotation.Configuration
public class Configuration implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

		userRepository.deleteAll();
		postRepository.deleteAll();

		User maria = new User(null, "Maria da Silva", "madasilva@gmail.com");
		User joão = new User(null, "João de Barros", "jdb@gmail.com");
		User felipe = new User(null, "Felipe Honorato", "fehonorato@gmail.com");
		User douglas = new User(null, "Douglas Mathias", "dougmathias@gmail.com");

		userRepository.saveAll(Arrays.asList(maria, joão, felipe, douglas));

		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu!!!", "Viajando para a terra da garoa!", maria);
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!!!", maria);

		postRepository.saveAll(Arrays.asList(post1, post2));

	}
}
