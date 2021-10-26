package com.alex.library.service;

import java.util.List;

import com.alex.library.dto.ReviewDto;
import com.alex.library.model.Review;

public interface ReviewService {
	List<Review> getUserReviews(Long userId);
	
	List<Review> getBookReviews(Long bookId);
	
	Review updateReview(ReviewDto reviewDto);
	
	Review addReview(ReviewDto review);
}
