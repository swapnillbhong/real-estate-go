package com.example.realestatego.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Import necessary packages
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.realestatego.dto.AppointmentDTO;
import com.example.realestatego.entity.Appointment;
import com.example.realestatego.exception.ResourceNotFoundException;
import com.example.realestatego.service.AppointmentService;

import jakarta.validation.Valid;

// RestController annotation to mark this class as a controller handling RESTful requests
@RestController
public class AppointmentController {

    // Autowired annotation to inject the AppointmentService bean
    @Autowired
    AppointmentService appointmentService;

    // PostMapping annotation to handle HTTP POST requests to "/appointment/addp"
    @PostMapping("/appointment/addp")

    // ResponseEntity to return a response with HTTP status and the added Appointment
    public Appointment addNewAppointment(@RequestBody Appointment a) throws ResourceNotFoundException {
        return appointmentService.addNewAppointment(a);
    }

    // GetMapping annotation to handle HTTP GET requests to "/listAppointments"
    @GetMapping("/listAppointments")

    // Method to get all appointments
    public List<AppointmentDTO> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    // GetMapping annotation to handle HTTP GET requests to "/appointment/{appointmentId}"
    @GetMapping("/appointment/{appointmentId}")

    // ResponseEntity to return a response with HTTP status and either the requested Appointment or an error message
    public ResponseEntity<Object> getAppointmentById(@PathVariable int appointmentId) {
        try {
            List<AppointmentDTO> appointment = appointmentService.getAppointmentById(appointmentId);
            return new ResponseEntity<>(appointment, HttpStatus.OK);
        } catch (ResourceNotFoundException ex) {
            // If the appointment is not found, return an error message with HTTP NOT FOUND status
            Map<String, String> map = new HashMap<>();
            map.put("errorMessage", ex.getMessage());
            return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
        }
    }

    // PutMapping annotation to handle HTTP PUT requests to "/appointment/update/{appointmentId}"
    @PutMapping("/appointment/update/{appointmentId}")

    // ResponseEntity to return a response with HTTP status and either the updated Appointment or an error message
    public ResponseEntity<Object> updateAppointment(@PathVariable int appointmentId, @Valid @RequestBody Appointment updatedAppointment
    ) {
        try {
            Appointment appointment = appointmentService.updateAppointment(appointmentId, updatedAppointment);
            return new ResponseEntity<>(appointment, HttpStatus.OK);
        } catch (ResourceNotFoundException ex) {
            // If the appointment is not found, return an error message with HTTP NOT FOUND status
            Map<String, String> map = new HashMap<>();
            map.put("errorMessage", ex.getMessage());
            return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
        }
    }

    // Uncomment the following block if you want to implement delete functionality
    /*
    @DeleteMapping("/{appointmentId}")
    public String deleteAppointment(@PathVariable int appointmentId) {
        appointmentServiceImpl.deleteAppointment(appointmentId);
        return "Appointment with id " + appointmentId + " deleted successfully.";
    }
    */
}
