package com.example.realestatego.dto;

import com.example.realestatego.entity.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {	// Class definition for the CustomerDTO (Data Transfer Object)
	private String id;
	private String name;
	private String email;
	private String contact;
	private Role role;
}
