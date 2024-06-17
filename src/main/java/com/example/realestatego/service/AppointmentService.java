package com.example.realestatego.service;

import java.util.List;

import com.example.realestatego.dto.AppointmentDTO;
import com.example.realestatego.entity.Appointment;
import com.example.realestatego.exception.ResourceNotFoundException;

//This is the service interface for handling business logic related to Appointment entities
public interface AppointmentService {
	// This is  used to add a new Appointment
	public Appointment addNewAppointment(Appointment a) throws ResourceNotFoundException;

	// This method is  used to update existing Appointment
	public Appointment updateAppointment(int id, Appointment b) throws ResourceNotFoundException;

	// This method is used to get a list of all Appointment
	public List<AppointmentDTO> getAllAppointments();

	public List<AppointmentDTO> getAppointmentById(int id) throws ResourceNotFoundException;

//	public void deleteAppointment(int id);
}
