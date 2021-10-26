package com.alex.library.repository;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.jboss.logging.Logger;

import com.alex.library.model.Review;

@Stateless
public class ReviewRepositoryImpl implements ReviewRepository {
	@PersistenceContext(unitName = "mysqlPU")
	private EntityManager em;
	static Logger logger = Logger.getLogger(ReviewRepositoryImpl.class);

	@SuppressWarnings("unchecked")
	@Override
	public List<Review> getReviewsForUser(Long id) {
		Query query = em.createQuery(
				"SELECT r FROM Review r WHERE r.appUser.id = :usId",Review.class);
		query.setParameter("usId", id);
		return (List<Review>) query.getResultList();
	}

	@Override
	public Review saveReview(Review review) {
		em.persist(review);
		return review;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Review> getReviewsForBook(Long id) {
		Query query = em.createQuery(
				"SELECT r FROM Review r WHERE r.book.id = :bookId",Review.class);
		query.setParameter("bookId", id);
		return (List<Review>) query.getResultList();
	}

	@Override
	public Review getReview(Long userId, Long bookId) {
		Query query = em.createQuery(
				"SELECT r FROM Review r WHERE r.book.id = :bookId AND r.appUser.id = :userId",Review.class);
		query.setParameter("bookId", bookId);
		query.setParameter("userId",userId);
		if(query.getResultList().isEmpty()) return null;
		return (Review) query.getSingleResult();
	}

	@Override
	public void delete(Long reviewId) {
		Review review = em.find(Review.class, reviewId);
		em.remove(review);
	}

	@Override
	public Review updateReview(Review review) {
		return em.merge(review);
	}

}
