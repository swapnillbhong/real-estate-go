package com.example.realestatego.controller;

// Import necessary packages
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.realestatego.entity.Admin;
import com.example.realestatego.service.AdminService;

import jakarta.validation.Valid;

// RestController annotation to mark this class as a controller handling RESTful requests
@RestController
public class AdminController {

    // Autowired annotation to inject the AdminService bean
	@Autowired
	AdminService adminService;

    // PostMapping annotation to handle HTTP POST requests to "/addadmin"
	@PostMapping("/addadmin")

    // Valid annotation to perform validation on the request body
	public Admin addNewAdmin(@RequestBody @Valid Admin admin) {
        // Call the AdminService to add a new Admin
		return adminService.addNewAdmin(admin);
	}
}
