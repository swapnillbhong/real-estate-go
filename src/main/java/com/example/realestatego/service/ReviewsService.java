package com.example.realestatego.service;

import java.util.List;

import com.example.realestatego.dto.ReviewsDTO;
import com.example.realestatego.entity.Reviews;
import com.example.realestatego.exception.ResourceNotFoundException;

public interface ReviewsService {
	// Add a new review
    public Reviews addNewReviews(Reviews review);

    // Update an existing review by ID
    public Reviews updateReview(int reviewId, Reviews updatedReview) throws ResourceNotFoundException;

    // Get a list of all reviews
	public List<ReviewsDTO> getAllReviewss();


//	public Reviews findReviewsById(int id) throws ResourceNotFoundException;

}
