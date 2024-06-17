package com.example.realestatego.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Appointment {
	// Primary key for the Appointment entity
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	// Description of the appointment
	private String description;

	// Date of the appointment
	private String date;


	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@ManyToOne
	@JoinColumn(name = "agent_id")
	private Agent agent;

	private String status; // Status of the appointment

	@Transient // Transient field to store the ID of the associated customer (not persisted in
				// the database)
	private String appointmentCustomerId;

	@Transient
	private String appointmentAgentId;

}
