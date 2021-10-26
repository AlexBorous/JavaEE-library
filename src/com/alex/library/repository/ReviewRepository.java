package com.alex.library.repository;

import java.util.List;

import com.alex.library.model.Review;

public interface ReviewRepository {
	List<Review> getReviewsForUser(Long id);

	List<Review> getReviewsForBook(Long id);

	Review saveReview(Review review);
	
	Review getReview(Long userId,Long bookId);
	
	void delete(Long reviewId);
	
	Review updateReview(Review review);
}
