package com.example.realestatego.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.realestatego.entity.Admin;
import com.example.realestatego.entity.Role;
import com.example.realestatego.repository.AdminRepository;
import com.example.realestatego.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminRepository adminRepository;
//	@Autowired
//	BCryptPasswordEncoder passwordEncoder;

	@Override
	public Admin addNewAdmin(Admin b) {
		// Encode the password before saving
//		b.setPassword(passwordEncoder.encode(b.getPassword()));

		// Set role as a Admin
	    Role role = new Role();
		role.setRole("Admin");
		b.setRole(role);

		// Set the generated unique ID by local Date and time
		LocalDateTime currentDateTime = LocalDateTime.now();
        String formattedDateTime = currentDateTime.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));

        String uniqueId = formattedDateTime + currentDateTime.getNano() / 1000000;
//        b.setId(Integer.parseInt(uniqueId));
        b.setId(b.getUsername()+uniqueId);

		return adminRepository.save(b);
	}

}
