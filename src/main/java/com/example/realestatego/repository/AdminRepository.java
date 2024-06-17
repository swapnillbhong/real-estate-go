package com.example.realestatego.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.realestatego.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, String>  {
	// The interface extends JpaRepository, specifying the entity type (Admin) and the type of the entity's primary key (String)

}
