package com.ml.mlbs;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.ml.mlbs.enums.ERole;
import com.ml.mlbs.model.RoleEntity;
import com.ml.mlbs.model.UserEntity;
import com.ml.mlbs.repository.UserRepository;

@SpringBootApplication
public class MlBSApplication {

	public static void main(String[] args) {
		SpringApplication.run(MlBSApplication.class, args);
	}

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	UserRepository userRepository;

	
	// @Bean
	// CommandLineRunner init() {
	// 	return args -> {
	// 		UserEntity userEntity = UserEntity.builder()
	// 				.email("a")
	// 				.username("kbe")
	// 				.password(passwordEncoder.encode("admin"))
	// 				.nombre("null")
	// 				.roles(Set.of(RoleEntity.builder()
	// 						.name(ERole.valueOf(ERole.ADMIN.name()))
	// 						.build()))
	// 				.build();
	// 		userRepository.save(userEntity);
	// 	};
	// }
	
}