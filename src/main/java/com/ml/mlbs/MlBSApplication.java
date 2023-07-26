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

	@Bean
	CommandLineRunner init() {
		return args -> {
			UserEntity userEntity = UserEntity.builder()
					.email("a@amail.com")
					.username("kbe")
					.password(passwordEncoder.encode("admin"))
					.nombre("null")
					.roles(Set.of(RoleEntity.builder()
							.name(ERole.valueOf(ERole.ADMIN.name()))
							.build()))
					.build();

					UserEntity userEntity2 = UserEntity.builder()
					.email("anyi@mail.com")
					.username("anyi")
					.password(passwordEncoder.encode("1234"))
					.roles(Set.of(RoleEntity.builder()
							.name(ERole.valueOf(ERole.USER.name()))
							.build()))
					.build();

					UserEntity userEntity3 = UserEntity.builder()
							.email("andrea@mail.com")
							.username("andrea")
							.password(passwordEncoder.encode("1234"))
							.roles(Set.of(RoleEntity.builder()
									.name(ERole.valueOf(ERole.INVITED.name()))
									.build()))
							.build();
				
					userRepository.save(userEntity);
					userRepository.save(userEntity2);
					userRepository.save(userEntity3);
		};
	}
	
}