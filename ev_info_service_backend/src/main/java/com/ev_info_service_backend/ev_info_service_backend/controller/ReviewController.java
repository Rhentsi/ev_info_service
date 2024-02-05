package com.ev_info_service_backend.ev_info_service_backend.controller;

import com.ev_info_service_backend.ev_info_service_backend.entity.Review;
import com.ev_info_service_backend.ev_info_service_backend.exceptions.ReviewNotFoundException;
import com.ev_info_service_backend.ev_info_service_backend.service.ReviewService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Endpoints to handle the CRUD operations of reviews

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    
    @Autowired
    private ReviewService reviewService;
    
    
    //Route to collect a single review
    @GetMapping("{id}")
    public ResponseEntity<Review> getReview(@PathVariable("id") Long id) throws ReviewNotFoundException {
        Review review = reviewService.getReview(id);
        
        return ResponseEntity.ok(review);
    }
    
    //Route to collect a list of all reviews available
    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews() {
        List<Review> reviews = reviewService.getAllReviews();
        
        return ResponseEntity.ok(reviews);
    }
    
    
    //Route to write a new review
    @PostMapping
    public ResponseEntity<Review> writeReview(@Valid @RequestBody Review review) {
        Review newReview = reviewService.createReview(review);
        return new ResponseEntity<>(review, HttpStatus.CREATED);
    }
    
    //Route to update an existing review
    @PutMapping("{id}")
    public ResponseEntity<Review> updateReview(@PathVariable("id") Long id, @RequestBody Review review) throws ReviewNotFoundException {
        Review updatedReview = reviewService.editReview(id, review);
        
        return ResponseEntity.ok(updatedReview);
    }
    
    //Route to delete a review by id
    @DeleteMapping("{id}")
    public String deleteReview(@PathVariable("id") Long id) throws ReviewNotFoundException {
        reviewService.deleteReview(id);
        
        return "Review with id " + id + " has been successfully deleted!";
    }
    
}
