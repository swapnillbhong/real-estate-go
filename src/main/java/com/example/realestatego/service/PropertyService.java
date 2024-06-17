package com.example.realestatego.service;

import java.util.List;

import com.example.realestatego.dto.PropertyDTO;
import com.example.realestatego.entity.Property;
import com.example.realestatego.exception.ResourceNotFoundException;

public interface PropertyService {
	// Add a new property
	public Property addNewProperty(Property b);

	// Update an existing property by ID
    public Property updateProperty(int propertyId, Property updatedProperty) throws ResourceNotFoundException;

    // Get a list of all properties
    public List<PropertyDTO> getAllProperty();

    // Find properties by name
    public List<PropertyDTO> findPropertyByName(String propertyName) throws ResourceNotFoundException;

    // Find properties by city
	List<PropertyDTO> findPropertyByCity(String propertyCity) throws ResourceNotFoundException;

}
