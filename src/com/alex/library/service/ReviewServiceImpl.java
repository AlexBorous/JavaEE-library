package com.alex.library.service;

import java.util.List;
import java.util.Optional;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.NotFoundException;

import com.alex.library.dto.ReviewDto;
import com.alex.library.exception.NoUserException;
import com.alex.library.model.AppUser;
import com.alex.library.model.Book;
import com.alex.library.model.Review;
import com.alex.library.repository.ReviewRepository;

@Stateless
public class ReviewServiceImpl implements ReviewService {

	@EJB
	private ReviewRepository reviewRepo;

	@EJB
	private UserService userService;

	@EJB
	private BookService bookService;

	@Override
	public List<Review> getUserReviews(Long userId) {

		return reviewRepo.getReviewsForUser(userId);
	}

	@Override
	public Review addReview(ReviewDto reviewDto) {
		Review review = new Review();
		AppUser appUser = Optional.ofNullable(userService.getAppUserById(reviewDto.getUser_id()))
				.orElseThrow(() -> new NotFoundException("User does not exists"));
		Book book = Optional.ofNullable(bookService.getBookById(reviewDto.getBook_id()))
				.orElseThrow(() -> new NotFoundException("Book does not exists"));
		review.setAppUser(appUser);
		review.setBook(book);
		review.setComment(reviewDto.getComment());
		review.setValue(reviewDto.getValue());
		return reviewRepo.saveReview(review);
	}

	@Override
	public List<Review> getBookReviews(Long bookId) {
		return reviewRepo.getReviewsForBook(bookId);
	}

	@Override
	public Review updateReview(ReviewDto reviewDto) {
		Review oldReview = Optional.ofNullable(reviewRepo.getReview(reviewDto.getUser_id(), reviewDto.getBook_id()))
				.orElseThrow(() -> new NoUserException("User or book does not exists", null));
		oldReview.setComment(reviewDto.getComment());
		oldReview.setValue(reviewDto.getValue());
		return reviewRepo.updateReview(oldReview);
	}

}
