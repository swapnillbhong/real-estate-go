package com.example.realestatego.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.realestatego.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String> {

	Optional<Customer> findByName(String username);

}
