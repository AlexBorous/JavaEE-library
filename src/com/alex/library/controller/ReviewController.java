package com.alex.library.controller;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.alex.library.dto.ReviewDto;
import com.alex.library.service.ReviewService;

@Path("/reviews")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ReviewController {
	@EJB
	private ReviewService reviewService;

	@GET
	@Path("/user")
	public Response findAllUserReviews(@QueryParam("userId") Long userId) {
		return Response.ok().entity(reviewService.getUserReviews(userId)).build();
	}

	@GET
	@Path("/book")
	public Response findBookReviews(@QueryParam("bookId") Long bookId) {
		if (bookId == null)
			return Response.status(Status.BAD_REQUEST).build();
		return Response.ok().entity(reviewService.getBookReviews(bookId)).build();
	}

	@POST
	public Response addReview(ReviewDto reviewDto) {
		return Response.ok().entity(reviewService.addReview(reviewDto)).build();
	}

	@DELETE
	public Response deleteUserReview(@QueryParam("id") String id) {
		return Response.ok().build();
	}

	@PUT
	public Response updateReview(ReviewDto reviewDto) {
		return Response.ok().entity(reviewService.updateReview(reviewDto)).build();
	}
}
