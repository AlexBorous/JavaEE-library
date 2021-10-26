package com.alex.library.mapper;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class NotFoundExceptionMapper implements ExceptionMapper<NotFoundException> {

	@Override
	public Response toResponse(NotFoundException notFoundException) {
		return Response.status(Response.Status.NO_CONTENT).entity(notFoundException.getMessage()).build();
	}

}
