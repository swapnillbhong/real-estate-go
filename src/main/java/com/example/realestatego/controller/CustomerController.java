package com.example.realestatego.controller;

// Import necessary packages
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.realestatego.dto.CustomerDTO;
import com.example.realestatego.entity.Customer;
import com.example.realestatego.exception.ResourceNotFoundException;
import com.example.realestatego.service.CustomerService;

import jakarta.validation.Valid;

// RestController annotation to mark this class as a controller handling RESTful requests
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerController {

	// Autowired annotation to inject the CustomerService bean
	@Autowired
	CustomerService customerService;

	// PostMapping annotation to handle HTTP POST requests to "/customer/add"
	@PostMapping(path = "/custsignup")

	// ResponseEntity to return a response with HTTP status and the added Customer
	public Customer addNewCustomer(@RequestBody @Valid Customer c) {
		return customerService.addNewCustomer(c);
	}

	// GetMapping annotation to handle HTTP GET requests to "/customer/viewall"
	@GetMapping("/customer/viewall")

	// Method to get all customers
	public List<CustomerDTO> getAllCustomers() {
		return customerService.getAllCustomers();
	}

	// GetMapping annotation to handle HTTP GET requests to
	// "/customer/view/{customerId}"
	@GetMapping("/customer/view/{customerId}")

	// ResponseEntity to return a response with HTTP status and either the requested
	// Customer or an error message
	public ResponseEntity<Object> getCustomerById(@PathVariable String customerId) {
		try {
			List<CustomerDTO> customer = customerService.findCustomerById(customerId);
			return new ResponseEntity<>(customer, HttpStatus.OK);
		} catch (ResourceNotFoundException ex) {
			// If the customer is not found, return an error message with HTTP NOT FOUND
			// status
			Map<String, String> map = new HashMap<>();
			map.put("errorMessage", ex.getMessage());
			return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
		}
	}

	// PutMapping annotation to handle HTTP PUT requests to
	// "/customer/update/{customerId}"
	@PutMapping("/customer/update/{customerId}")

	// ResponseEntity to return a response with HTTP status and either the updated
	// Customer or an error message
	public ResponseEntity<Object> updateCustomer(@PathVariable String customerId,
			@Valid @RequestBody Customer updatedCustomer) {
		try {
			Customer updatedC = customerService.updateCustomer(customerId, updatedCustomer);
			return new ResponseEntity<>(updatedC, HttpStatus.OK);
		} catch (ResourceNotFoundException ex) {
			// If the customer is not found, return an error message with HTTP NOT FOUND
			// status
			Map<String, String> map = new HashMap<>();
			map.put("errorMessage", ex.getMessage());
			return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
		}
	}

	// Uncomment the following block if you want to implement delete functionality
	/*
	 * @DeleteMapping("/{custid}") public String deleteCustomer(@PathVariable int
	 * custid) { customerServiceImpl.deleteCustomer(custid); return
	 * "Customer with id " + custid + " deleted successfully."; }
	 */
}
