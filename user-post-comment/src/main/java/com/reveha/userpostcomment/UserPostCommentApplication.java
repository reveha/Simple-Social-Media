package com.reveha.userpostcomment;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class UserPostCommentApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserPostCommentApplication.class, args);
		System.out.println("Merhaba Yeni VERSION");
	}

	@Bean
	public ModelMapper getMapper(){
		return new ModelMapper();
	}

}
