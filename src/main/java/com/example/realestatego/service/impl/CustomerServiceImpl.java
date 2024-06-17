package com.example.realestatego.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.realestatego.dto.CustomerDTO;
import com.example.realestatego.entity.Customer;
import com.example.realestatego.entity.Role;
import com.example.realestatego.exception.ResourceNotFoundException;
import com.example.realestatego.repository.CustomerRepository;
import com.example.realestatego.service.CustomerService;
import com.example.realestatego.service.EmailNotificationService;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	CustomerRepository customerRepository;
//	@Autowired
//	BCryptPasswordEncoder passwordEncoder;
	@Autowired
	ModelMapper modelMapper;

	@Autowired
	private EmailNotificationService emailNotificationService;

	@Override
	public Customer addNewCustomer(Customer c) {

		Role role = new Role();
		role.setRole("Customer");
		c.setRole(role);

		LocalDateTime currentDateTime = LocalDateTime.now();
		String formattedDateTime = currentDateTime.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
		String uniqueId = formattedDateTime + currentDateTime.getNano() / 1000000;
		c.setId(c.getUsername()+uniqueId);

//		c.setPassword(passwordEncoder.encode(c.getPassword()));

		// Notify the customer by email
		notifyNewCustomerEmail(c);

		return customerRepository.save(c);
	}

	private void notifyNewCustomerEmail(Customer c) {
		String customerEmail = c.getEmail().trim();
		emailNotificationService.sendWelcomeEmail(customerEmail, c.getName());
	}

	@Override
	public Customer updateCustomer(String customerId, Customer updatedCustomer) throws ResourceNotFoundException {
		Optional<Customer> existingCustomerOptional = customerRepository.findById(customerId);

		if (existingCustomerOptional.isPresent()) {
			Customer existingCustomer = existingCustomerOptional.get();
			// Update fields of the existing customer with the values from updatedCustomer
			existingCustomer.setName(updatedCustomer.getName());
			existingCustomer.setContact(updatedCustomer.getContact());
			existingCustomer.setAddress(updatedCustomer.getAddress());
			existingCustomer.setEmail(updatedCustomer.getEmail());
			existingCustomer.setRole(updatedCustomer.getRole());
			existingCustomer.setUsername(updatedCustomer.getUsername());
			existingCustomer.setPassword(updatedCustomer.getPassword());

			return customerRepository.save(existingCustomer);
		} else {
			// Handle the case where the customer with the given ID is not found
			throw new ResourceNotFoundException("Customer", " id", customerId);
		}
	}

	@Override
	public List<CustomerDTO> getAllCustomers() {
		List<Customer> customers = customerRepository.findAll();
		return customers.stream().map(c -> modelMapper.map(c, CustomerDTO.class)).collect(Collectors.toList());

	}

	@Override
	public List<CustomerDTO> findCustomerById(String customerId) throws ResourceNotFoundException {
		Optional<Customer> customerOptional = customerRepository.findById(customerId);

		if (customerOptional.isPresent()) {
			return customerOptional.stream().map(customer -> modelMapper.map(customerOptional, CustomerDTO.class))
					.collect(Collectors.toList());
		} else {
			// Handle the case where the customer with the given ID is not found
			throw new ResourceNotFoundException("Customer", " id", customerId);
		}

	}

	public static String generateUniqueId() {
		// Generate a random UUID
		UUID uuid = UUID.randomUUID();

		// Convert UUID to a string and remove hyphens
		String id = uuid.toString().replace("-", "");

		return id;
	}

//	@Override
//    public void deleteCustomer(int customerId) {
//        customerRepository.deleteById(customerId);
//    }

}
