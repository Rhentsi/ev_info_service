package com.ev_info_service_backend.ev_info_service_backend.service.impl;

import com.ev_info_service_backend.ev_info_service_backend.entity.Review;
import com.ev_info_service_backend.ev_info_service_backend.exceptions.ReviewNotFoundException;
import com.ev_info_service_backend.ev_info_service_backend.repository.ReviewRepository;
import com.ev_info_service_backend.ev_info_service_backend.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//Implementation of CRUD operations for the review data structure

@Service
public class ReviewServiceImpl implements ReviewService {
    
    @Autowired
    private ReviewRepository reviewRepository;

    
    //Create a new review
    @Override
    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }

    //Get a single review by id
    @Override
    public Review getReview(Long id) throws ReviewNotFoundException {
        return reviewRepository.findById(id).orElseThrow(
                () -> new ReviewNotFoundException("Review does not exist")
        );
    }

    //Collect a full list of reviews
    @Override
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    //Update a review by id
    @Override
    public Review editReview(Long id, Review review) throws ReviewNotFoundException {
        Review updatedReview = reviewRepository.findById(id).orElseThrow(
                () -> new ReviewNotFoundException("Review does not exist")
        );
        
        updatedReview.setUsername(review.getUsername());
        updatedReview.setComment(review.getComment());
        updatedReview.setPositive(review.getPositive());
        return reviewRepository.save(updatedReview);
    }

    //Delete a review by id
    @Override
    public void deleteReview(Long id) throws ReviewNotFoundException {
        Review review = reviewRepository.findById(id).orElseThrow(
                () -> new ReviewNotFoundException("Review does not exist")
        );
        reviewRepository.deleteById(id);
    }
}
