package com.alex.library.controller;

import javax.annotation.security.PermitAll;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/users")
public class UserController {
	
	@POST
	@Path("/register")
	@PermitAll
	public Response registerUser() {
		return Response.created(null).build();
	}
	
	@POST
	@Path("/login")
	@PermitAll
	public Response loginUser() {
		return Response.ok().build();
	}
	
	@GET
	@Path("/all")
	public String findAllUsers() {
		return "All Users";
	}

	@GET
	@Path("/{id}")
	public String findUserById(@PathParam("id") String id) {
		return "user with id : " + id;
	}

	@GET
	public String findUserByName(@QueryParam("name") String name) {
		return "user with name : " + name;
	}
	
	@DELETE
	public Response deleteUser(@QueryParam("id") String id) {
		return Response.ok().build();
	}
	
	@PUT
	public Response updateUser() {
		return Response.accepted().build();
	}
}
