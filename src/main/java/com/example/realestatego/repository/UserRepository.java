package com.example.realestatego.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.realestatego.entity.Users;

public interface UserRepository extends JpaRepository<Users, String> {
	//  this  method is used to find a user by name
	Optional<Users> findByUsername(String username);

}
