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

import com.example.realestatego.dto.PropertyDTO;
import com.example.realestatego.entity.Property;
import com.example.realestatego.exception.ResourceNotFoundException;
import com.example.realestatego.service.PropertyService;

import jakarta.validation.Valid;

// RestController annotation to mark this class as a controller handling RESTful requests
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PropertyController {

    // Autowired annotation to inject the PropertyService bean
    @Autowired
    PropertyService propertyService;

    // PostMapping annotation to handle HTTP POST requests to "/propertyAdd"
    @PostMapping("/propertyAdd")

    // Method to add a new property
    public Property addNewProperty(@RequestBody Property p) {
        System.out.println("Received a request to add property: " + p);
        return propertyService.addNewProperty(p);
    }

    // GetMapping annotation to handle HTTP GET requests to "/propertyList"
    @GetMapping("/propertyList")

    // ResponseEntity to return a response with HTTP status and either a list of PropertyDTOs or NO_CONTENT status
    public ResponseEntity<List<PropertyDTO>> getAllProperty() {
        List<PropertyDTO> properties = propertyService.getAllProperty();

        if (properties.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(properties, HttpStatus.OK);
        }
    }

    // PutMapping annotation to handle HTTP PUT requests to "/{propertyId}"
    @PutMapping("/{propertyId}")

    // ResponseEntity to return a response with HTTP status and either the updated Property or an error message
    public ResponseEntity<Object> updateProperty(@PathVariable int propertyId,
            @Valid @RequestBody Property updatedProperty) {
        try {
            Property property = propertyService.updateProperty(propertyId, updatedProperty);
            return new ResponseEntity<>(property, HttpStatus.OK);
        } catch (ResourceNotFoundException ex) {
            // If the property is not found, return an error message with HTTP NOT FOUND status
            Map<String, String> map = new HashMap<>();
            map.put("errorMessage", ex.getMessage());
            return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
        }
    }

    // GetMapping annotation to handle HTTP GET requests to "/property/name/{propertyName}"
    @GetMapping("/property/name/{propertyName}")

    // ResponseEntity to return a response with HTTP status and either a list of PropertyDTOs or an error message
    public ResponseEntity<Object> findPropertyByName(@PathVariable String propertyName) {
        try {
            List<PropertyDTO> property = propertyService.findPropertyByName(propertyName);
            return new ResponseEntity<>(property, HttpStatus.OK);
        } catch (ResourceNotFoundException ex) {
            // If the property is not found, return an error message with HTTP NOT FOUND status
            Map<String, String> map = new HashMap<>();
            map.put("errorMessage", ex.getMessage());
            return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
        }
    }

    // GetMapping annotation to handle HTTP GET requests to "/property/{propertyAddress}"
    @GetMapping("/property/city/{propertyCity}")

    // ResponseEntity to return a response with HTTP status and either a list of PropertyDTOs or an error message
    public ResponseEntity<Object> findPropertyByCity(@PathVariable String propertyCity) {
        try {
            List<PropertyDTO> property = propertyService.findPropertyByCity(propertyCity);
            return new ResponseEntity<>(property, HttpStatus.OK);
        } catch (ResourceNotFoundException ex) {
            // If the property is not found, return an error message with HTTP NOT FOUND status
            Map<String, String> map = new HashMap<>();
            map.put("errorMessage", ex.getMessage());
            return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
        }
    }
}
