package com.example.realestatego.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewsDTO {	// Class definition for the ReviewsDTO (Data Transfer Object)
	private String comment;
	private float rating;
	private CustomerNameDTO customerName= new CustomerNameDTO();
	private PropertyNameDTO propertyName= new PropertyNameDTO();
}
