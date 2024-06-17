
package com.example.realestatego.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.realestatego.dto.ReviewsDTO;
import com.example.realestatego.entity.Customer;
import com.example.realestatego.entity.Property;
import com.example.realestatego.entity.Reviews;
import com.example.realestatego.exception.ResourceNotFoundException;
import com.example.realestatego.repository.CustomerRepository;
import com.example.realestatego.repository.PropertyRepository;
import com.example.realestatego.repository.ReviewsRepository;
import com.example.realestatego.service.ReviewsService;

@Service
public class ReviewsServiceImpl implements ReviewsService {
	@Autowired
	ReviewsRepository reviewsRepository;
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	PropertyRepository propertyRepository;

	@Autowired
	ModelMapper modelMapper;

	@Override
    public Reviews addNewReviews(Reviews r) { 	//Adds a new review.
        Customer c1 = customerRepository.findById(r.getReviewsCustomerId()).orElse(null);
        Property p1 = propertyRepository.findById(r.getReviewsPropertyId()).orElse(null);

        if (c1 != null && p1 != null) {
            r.setCustomer(c1);
            r.setProperty(p1);
            return reviewsRepository.save(r);
        } else {
            return null;
        }
    }

	@Override 	//Updates an existing review
    public Reviews updateReview(int reviewsId, Reviews updatedReview) throws ResourceNotFoundException {
        Reviews existingReview = reviewsRepository.findById(reviewsId)
                .orElseThrow(() -> new ResourceNotFoundException("Review", " id", reviewsId));

        existingReview.setComment(updatedReview.getComment());
        existingReview.setRating(updatedReview.getRating());

        return reviewsRepository.save(existingReview);
    }

	@Override
	public List<ReviewsDTO> getAllReviewss() {
		List<Reviews> reviews = reviewsRepository.findAll();
		return reviews.stream().map(review -> {
			ReviewsDTO reviewDTO = modelMapper.map(review, ReviewsDTO.class);

			// Assuming you have a getName() method in CustomerDTO and AgentDTO
			String customerName = review.getCustomer().getName();
			String propertyName = review.getProperty().getName();

			reviewDTO.getCustomerName().setName(customerName);
			reviewDTO.getPropertyName().setName(propertyName);

			return reviewDTO;
		}).collect(Collectors.toList());
	}


//	@Override
//    public Reviews findReviewsById(int reviewId) throws ResourceNotFoundException {
//        Optional<Reviews> reviewOptional = reviewsRepository.findById(reviewId);
//
//        if (reviewOptional.isPresent()) {
//            return reviewOptional.get();
//        } else {
//            throw new ResourceNotFoundException("Review", " id", reviewId);
//        }
//    }



}
