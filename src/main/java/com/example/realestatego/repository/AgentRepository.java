package com.example.realestatego.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.realestatego.entity.Agent;

public interface AgentRepository extends JpaRepository<Agent, String> {
	// The interface extends JpaRepository, specifying Agent and the type of the entity's primary key (String)

}
