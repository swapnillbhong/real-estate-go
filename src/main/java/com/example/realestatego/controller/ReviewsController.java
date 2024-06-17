package com.example.realestatego.controller;
// Import necessary packages
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.realestatego.dto.ReviewsDTO;
import com.example.realestatego.entity.Reviews;
import com.example.realestatego.exception.ResourceNotFoundException;
import com.example.realestatego.service.ReviewsService;

import jakarta.validation.Valid;

// RestController annotation to mark this class as a controller handling RESTful requests
@RestController
public class ReviewsController {

    // Autowired annotation to inject the ReviewsService bean
    @Autowired
    private ReviewsService reviewsService;

    // PostMapping annotation to handle HTTP POST requests to "/reviews"
    @PostMapping("/reviews")

    // ResponseEntity to return a response with HTTP status and either the added Reviews or an error message
    public ResponseEntity<Object> addNewReview(@Valid @RequestBody Reviews review) {
        try {
            Reviews addedReview = reviewsService.addNewReviews(review);
            return new ResponseEntity<>(addedReview, HttpStatus.CREATED);
        } catch (Exception e) {
            // If adding the review fails, return an error message with HTTP BAD REQUEST status
            return new ResponseEntity<>("Failed to add review: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    // PutMapping annotation to handle HTTP PUT requests to "/reviews/{reviewId}"
    @PutMapping("/reviews/{reviewId}")

    // ResponseEntity to return a response with HTTP status and either the updated Reviews or an error message
    public ResponseEntity<Object> updateReview(@PathVariable int reviewId, @Valid @RequestBody Reviews updatedReview) {
        try {
            Reviews review = reviewsService.updateReview(reviewId, updatedReview);
            return new ResponseEntity<>(review, HttpStatus.OK);
        } catch (ResourceNotFoundException ex) {
            // If the review is not found, return an error message with HTTP NOT FOUND status
            Map<String, String> map = new HashMap<>();
            map.put("errorMessage", ex.getMessage());
            return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
        }
    }

    // GetMapping annotation to handle HTTP GET requests to "/reviews/view"
    @GetMapping("/reviews/view")

    // Method to get all reviews
    public List<ReviewsDTO> getAllReviews() {
        return reviewsService.getAllReviewss();
    }

    // Uncomment the following block if you want to implement getting a review by ID
    /*
    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Object> getReviewById(@PathVariable int reviewId) throws ResourceNotFoundException {
        Reviews review = reviewsService.findReviewsById(reviewId);
        return new ResponseEntity<>(review, HttpStatus.OK);
    }
    */
}
