package com.example.realestatego.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.realestatego.dto.PropertyDTO;
import com.example.realestatego.entity.Agent;
import com.example.realestatego.entity.Property;
import com.example.realestatego.exception.ResourceNotFoundException;
import com.example.realestatego.repository.AgentRepository;
import com.example.realestatego.repository.PropertyRepository;
import com.example.realestatego.service.PropertyService;

@Service
public class PropertyServiceImpl implements PropertyService {

	@Autowired
	private PropertyRepository propertyRepository;
	@Autowired
	private AgentRepository agentRepository;
	@Autowired
	ModelMapper modelMapper;

	@Override
	public Property addNewProperty(Property p) {
		Agent a1 = agentRepository.findById(p.getPropertyAgentId()).get();
		p.setAgent(a1);
		return propertyRepository.save(p);
	}

	@Override
	public List<PropertyDTO> getAllProperty() {
		List<Property> properties = propertyRepository.findAll();
//		 return properties.stream().map(property -> modelMapper.map(property, PropertyDTO.class)).collect(Collectors.toList());
		return properties.stream().map(p -> modelMapper.map(p, PropertyDTO.class)).collect(Collectors.toList());
	}

	@Override
	public List<PropertyDTO> findPropertyByName(String propertyName) throws ResourceNotFoundException {
		Optional<Property> propertyOptional = propertyRepository.findByName(propertyName);

		if (propertyOptional.isPresent()) {
			return propertyOptional.stream().map(property ->modelMapper.map(propertyOptional,PropertyDTO.class)).collect(Collectors.toList());
		} else {
			throw new ResourceNotFoundException("Property", " id", propertyName);
		}
	}

	@Override
	public List<PropertyDTO> findPropertyByCity(String propertyCity) throws ResourceNotFoundException {
		Optional<Property> propertyOptional = propertyRepository.findByCity(propertyCity);

		if (propertyOptional.isPresent()) {
			return propertyOptional.stream().map(property ->modelMapper.map(propertyOptional,PropertyDTO.class)).collect(Collectors.toList());
		} else {
			throw new ResourceNotFoundException("Property", " id", propertyCity);
		}
	}

	@Override
	public Property updateProperty(int propertyId, Property updatedProperty) throws ResourceNotFoundException {
		Optional<Property> existingPropertyOptional = propertyRepository.findById(propertyId);

		if (existingPropertyOptional.isPresent()) {
			Property existingProperty = existingPropertyOptional.get();
			// Update fields of the existing property with the values from updatedProperty
			existingProperty.setName(updatedProperty.getName());
			existingProperty.setDescription(updatedProperty.getDescription());
			existingProperty.setPrice(updatedProperty.getPrice());
			existingProperty.setPropertyType(updatedProperty.getPropertyType());
//			existingProperty.setPropertyImage(updatedProperty.getPropertyImage());
			existingProperty.setStatus(updatedProperty.getStatus());


			return propertyRepository.save(existingProperty);
		} else {
			// Handle the case where the property with the given ID is not found
			throw new ResourceNotFoundException("Property", " id", propertyId);
		}
	}

}
