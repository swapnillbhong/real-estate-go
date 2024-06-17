package com.example.realestatego.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.realestatego.entity.Property;

public interface PropertyRepository extends JpaRepository<Property, Integer> {
//  these are customized methods used to find a property by name and ByCity
	Optional<Property> findByName(String propertyName);
	Optional<Property> findByCity(String propertyCity);
}
