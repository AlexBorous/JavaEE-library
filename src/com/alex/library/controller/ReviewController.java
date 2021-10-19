package com.alex.library.controller;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/reviews")
public class ReviewController {
	@GET
	@Path("/{userId}/all")
	public String findAllUserReviews(@PathParam("userId") String userId) {
		return "All Reviews regarding user with id : "+ userId;
	}

	@GET
	@Path("/{userId}/{id}")
	public String findUserReviewById(@PathParam("userId") String userId ,@PathParam("id") String id) {
		return "review for user with id : " + userId + " review id : " + id;
	}

	@GET
	@Path("/{bookId}")
	public String findBookReview(@PathParam("bookId") String bookId ) {
		if(bookId == null)
			return "check docs please";
		return "book with name : " + bookId;
	}

	@POST
	@Path("/{userId}")
	public void addUserReview(@PathParam("userId") String userId ) {

	}

	@DELETE
	@Path("/{userId}")
	public Response deleteUserReview(@PathParam("userId") String userId ,@QueryParam("id") String id) {
		return Response.ok().build();
	}
	
	@PUT
	@Path("/{userId}/{id}")
	public Response updateUserReview(@PathParam("userId") String userId,@PathParam("id") String id) {
		return Response.accepted().build();
	}
}
