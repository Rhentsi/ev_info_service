package com.ev_info_service_backend.ev_info_service_backend.service;

import com.ev_info_service_backend.ev_info_service_backend.entity.Review;
import com.ev_info_service_backend.ev_info_service_backend.exceptions.ReviewNotFoundException;

import java.util.List;

public interface ReviewService {
    
    Review createReview(Review review);
    
    Review getReview(Long id) throws ReviewNotFoundException;
    
    List<Review> getAllReviews();
    
    Review editReview(Long id, Review review) throws ReviewNotFoundException;
    
    void deleteReview(Long id) throws ReviewNotFoundException;
}
