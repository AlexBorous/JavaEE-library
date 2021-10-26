package com.alex.library.mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.alex.library.exception.NoUserException;
@Provider
public class NoUserExceptionMapper implements ExceptionMapper<NoUserException>{
	@Override
	public Response toResponse(NoUserException noUserException) {
		return Response.status(Response.Status.NO_CONTENT).entity(noUserException.getMessage()).build();
	}

}

