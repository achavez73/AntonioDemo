package com.example.AntonioDemo;

import com.example.AntonioDemo.dao.AccountsDAO;
import com.example.AntonioDemo.dao.AccountsDAOImpl;
import com.example.AntonioDemo.dao.UsersDAO;
import com.example.AntonioDemo.dao.UsersDAOImpl;
import com.example.AntonioDemo.dto.AccountsDTO;
import com.example.AntonioDemo.dto.AccountsDTOImpl;
import com.example.AntonioDemo.dto.UsersDTO;
import com.example.AntonioDemo.dto.UsersDTOImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AntonioDemoApplication {

	@Bean
	public UsersDTO usersDTO() {
		return new UsersDTOImpl();
	}

	@Bean
	public UsersDAO usersDAO(){
		return new UsersDAOImpl();
	}

	@Bean
	public AccountsDTO accountsDTO() {
		return new AccountsDTOImpl();
	}

	@Bean
	public AccountsDAO accountsDAO(){
		return new AccountsDAOImpl();
	}

	public static void main(String[] args) {
		SpringApplication.run(AntonioDemoApplication.class, args);
	}

}
