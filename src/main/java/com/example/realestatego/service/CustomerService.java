package com.example.realestatego.service;

import java.util.List;

import com.example.realestatego.dto.CustomerDTO;
import com.example.realestatego.entity.Customer;
import com.example.realestatego.exception.ResourceNotFoundException;

//This is the service interface for handling business logic related to Customer entities
public interface CustomerService {
	public Customer addNewCustomer(Customer b)  ;

	public Customer updateCustomer(String customerId, Customer updatedCustomer) throws ResourceNotFoundException;

	public List<CustomerDTO> getAllCustomers() ;

	public List<CustomerDTO> findCustomerById(String id) throws ResourceNotFoundException;

	//	getCustomerById
//	public void deleteCustomer(int customerId);
}
