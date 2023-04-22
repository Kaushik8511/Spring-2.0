package com.jwt.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jwt.api.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	 Optional<User> findByEmail(String email);
	
}
