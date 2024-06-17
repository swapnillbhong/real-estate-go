package com.example.realestatego.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDTO {
	private String date;
	private CustomerNameDTO customerName = new CustomerNameDTO();
    private AgentNameDTO agentName = new AgentNameDTO();
	private String status;

}
