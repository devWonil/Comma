package com.JMThouseWeb.JMThouse.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.JMThouseWeb.JMThouse.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	Optional<User> findByUsername(String username);

//	User findByUsernameAndPassword(String username, String password);
	
}
