package com.example.realestatego.entity;
//Import necessary packages
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Lombok annotations for automatically generating boilerplate code
@Data
@AllArgsConstructor
@NoArgsConstructor

//JPA Entity annotation to mark this class as an entity
@Entity

//DiscriminatorValue annotation for specifying the discriminator value for this entity
@DiscriminatorValue(value = "Agent")
public class Agent extends Users {

	// Enumerated annotation for specifying the persistence of an enumerated type
	@Enumerated(value = EnumType.STRING)
	private AgentProfession agentProfession;

	// OneToMany annotation for specifying a one-to-many relationship with Appointment entities
	@OneToMany(mappedBy = "agent")

	// JsonIgnore annotation to ignore the appointments field during JSON serialization/deserialization
	@JsonIgnore
	private List<Appointment> appointments;

	// OneToMany annotation for specifying a one-to-many relationship with Property entities
	@OneToMany(mappedBy = "agent", cascade = CascadeType.ALL)

	// JsonIgnore annotation to ignore the properties field during JSON serialization/deserialization
	@JsonIgnore
	private List<Property> properties;
}
