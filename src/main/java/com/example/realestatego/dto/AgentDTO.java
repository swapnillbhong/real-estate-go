package com.example.realestatego.dto;

import com.example.realestatego.entity.AgentProfession;
import com.example.realestatego.entity.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data     //Data annotation from Lombok to automatically generate getters, setters, toString, equals, and hashCode methods
@AllArgsConstructor    //to generate a constructor with all fields
@NoArgsConstructor     //generate a default constructor with no arguments
public class AgentDTO { 	//Class definition for the AgentDTO (Data Transfer Object)
	private String id;
	private String name;
	private String email;
	private String contact;
	private Role role;
	private AgentProfession agentProfession;
}
