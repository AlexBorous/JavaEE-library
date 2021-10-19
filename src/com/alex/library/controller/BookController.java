package com.alex.library.controller;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.jboss.logging.Logger;



@Path("/books")
public class BookController {
	   static Logger logger = Logger.getLogger(BookController.class);
	@GET
	@Path("/all")
	public String findAllBooks() {
		logger.info("All books retrieved");
		return "All Books";
	}

	@GET
	@Path("/{id}")
	public String findBookById(@PathParam("id") String id) {
		return "book with id : " + id;
	}

	@GET
	public String findBookByName(@QueryParam("name") String name) {
		if(name == null)
			return "check docs please";
		return "book with name : " + name;
	}

	@POST
	public void addBook() {

	}

	@DELETE
	public Response deleteBook(@QueryParam("id") String id) {
		return Response.ok().build();
	}
	
	@PUT
	public Response updateBook() {
		return Response.accepted().build();
	}
}
