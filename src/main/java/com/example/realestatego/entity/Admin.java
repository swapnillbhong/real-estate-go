package com.example.realestatego.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@AllArgsConstructor
//@NoArgsConstructor
@Entity
@DiscriminatorValue(value = "Admin")	// it specify the discriminator value for this entity in the inheritance hierarchy
public class Admin extends Users {

//	@OneToMany
//	Agent agent;

}
