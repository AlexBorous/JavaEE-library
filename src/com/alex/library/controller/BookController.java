package com.alex.library.controller;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.jboss.logging.Logger;

import com.alex.library.dto.BookDto;
import com.alex.library.service.BookService;

@Path("/books")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookController {
	static Logger logger = Logger.getLogger(BookController.class);

	@EJB
	private BookService bookService;

	@GET
	@Path("/all")
	public Response findAllAuthorBooks(@QueryParam("author") String author) {
		if (author == null || author.isEmpty())
			return Response.status(Status.BAD_REQUEST).build();
		logger.info("All books retrieved");
		return Response.ok().entity(bookService.getAuthorBooks(author)).build();
	}

	@GET
	@Path("/{id}")
	public Response findBookById(@PathParam("id") String id) {
		return Response.ok().build();
	}

	@GET
	public Response findBookByName(@QueryParam("name") String name) {
		if (name == null)
			return Response.status(Status.BAD_REQUEST).build();
		return Response.ok().build();
	}

	@POST
	public Response addBook(BookDto book) {
		return Response.created(null).entity(bookService.addBook(book)).build();
	}

	@DELETE
	public Response deleteBook(@QueryParam("id") Long bookId) {
		bookService.deleteBook(bookId);
		return Response.ok().build();
	}

	@PUT
	public Response updateBook(@QueryParam("id") Long id, BookDto book) {
		return Response.accepted().entity(bookService.updateBook(id, book)).build();
	}
}
