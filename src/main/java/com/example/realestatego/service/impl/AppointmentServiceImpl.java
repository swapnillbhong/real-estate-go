package com.example.realestatego.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.realestatego.dto.AppointmentDTO;
import com.example.realestatego.entity.Agent;
import com.example.realestatego.entity.Appointment;
import com.example.realestatego.entity.Customer;
import com.example.realestatego.exception.ResourceNotFoundException;
import com.example.realestatego.repository.AgentRepository;
import com.example.realestatego.repository.AppointmentRepository;
import com.example.realestatego.repository.CustomerRepository;
import com.example.realestatego.service.AppointmentService;
import com.example.realestatego.service.EmailNotificationService;

@Service
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	private AppointmentRepository appointmentRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private AgentRepository agentRepository;
	@Autowired
	private EmailNotificationService emailNotificationService;
	@Autowired
	ModelMapper modelMapper;

	@Override
	public Appointment addNewAppointment(Appointment appointment) throws ResourceNotFoundException {
		// Find the customer using the provided customer ID
		Customer customer = customerRepository.findById(appointment.getAppointmentCustomerId()).orElseThrow(
				() -> new ResourceNotFoundException("Customer", " id", appointment.getAppointmentCustomerId()));
		// Find the agent using the provided agent ID
		Agent agent = agentRepository.findById(appointment.getAppointmentAgentId())
				.orElseThrow(() -> new ResourceNotFoundException("Agent", " id", appointment.getAppointmentAgentId()));

//		CustomerDTO customerDTO = modelMapper.map(customer, CustomerDTO.class);

		appointment.setCustomer(customer);
		appointment.setAgent(agent);
		notifyNewCustomerEmail(customer, appointment);
		return appointmentRepository.save(appointment);
	}

	// to send a notification email to the customer for a new appointment
	private void notifyNewCustomerEmail(Customer c, Appointment a) {
		String customerEmail = c.getEmail().trim();
		emailNotificationService.NewAppointmentEmail(customerEmail, c.getName(), a.getDate(), c.getAddress());
	}

	@Override
	public Appointment updateAppointment(int appointmentId, Appointment updatedAppointment)
			throws ResourceNotFoundException {
		Optional<Appointment> existingAppointmentOptional = appointmentRepository.findById(appointmentId);

		if (existingAppointmentOptional.isPresent()) {
			Appointment existingAppointment = existingAppointmentOptional.get();
			// Update fields of the existing appointment with the values from
			// updatedAppointment
			existingAppointment.setDescription(updatedAppointment.getDescription());
			existingAppointment.setDate(updatedAppointment.getDate());
			existingAppointment.setCustomer(updatedAppointment.getCustomer());
			existingAppointment.setAgent(updatedAppointment.getAgent());
			existingAppointment.setStatus(updatedAppointment.getStatus());

			return appointmentRepository.save(existingAppointment);
		} else {
			// Handle the case where the appointment with the given ID is not found
			throw new ResourceNotFoundException("Appointment", " id", appointmentId);
		}
	}

	@Override
	public List<AppointmentDTO> getAllAppointments() {
		List<Appointment> appointments = appointmentRepository.findAll();
		return appointments.stream().map(appointment -> {
			AppointmentDTO appointmentDTO = modelMapper.map(appointment, AppointmentDTO.class);

			// Assuming you have a getName() method in CustomerDTO and AgentDTO
			String customerName = appointment.getCustomer().getName();
			String agentName = appointment.getAgent().getName();

			appointmentDTO.getCustomerName().setName(customerName);
			appointmentDTO.getAgentName().setName(agentName);

			return appointmentDTO;
		}).collect(Collectors.toList());
	}

	@Override
	public List<AppointmentDTO> getAppointmentById(int appointmentId) throws ResourceNotFoundException {
		Optional<Appointment> appointmentOptional = appointmentRepository.findById(appointmentId);

		if (appointmentOptional.isPresent()) {
			return appointmentOptional.stream().map(appointment -> {
				AppointmentDTO appointmentDTO = modelMapper.map(appointment, AppointmentDTO.class);

				// Assuming you have a getName() method in CustomerDTO and AgentDTO
				String customerName = appointment.getCustomer().getName();
				String agentName = appointment.getAgent().getName();

				appointmentDTO.getCustomerName().setName(customerName);
				appointmentDTO.getAgentName().setName(agentName);

				return appointmentDTO;
			}).collect(Collectors.toList());
		} else {
			// Handle the case where the appointment with the given ID is not found
			throw new ResourceNotFoundException("Appointment", " id", appointmentId);
		}
	}

//	@Override
//	public void deleteAppointment(int id) {
//		// TODO Auto-generated method stub
//
//	}
}
