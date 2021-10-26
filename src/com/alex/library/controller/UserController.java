package com.alex.library.controller;

import javax.ejb.EJB;
import javax.validation.Valid;
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

import com.alex.library.dto.UserDto;
import com.alex.library.service.UserService;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {
	static Logger logger = Logger.getLogger(UserController.class);

	@EJB
	private UserService userService;

	@POST
	@Path("/register")
	public Response registerUser(@Valid UserDto user) {
		return Response.created(null).entity(userService.registerUser(user)).build();
	}

	@GET
	@Path("/login")
	public Response loginUser() {
		return Response.ok().build();
	}

	@GET
	@Path("/all")
	public Response findAllUsers() {
		return Response.ok().entity(userService.getAllUsers()).build();
	}

	@GET
	@Path("/{id}")
	public Response findUserById(@PathParam("id") Long id) {
		return Response.ok().entity(userService.getAppUserById(id)).build();
	}

	@GET
	public Response findUserByName(@QueryParam("name") String name) {
		if (name == null)
			return Response.noContent().build();
		return Response.ok().entity(userService.getAppUserByName(name)).build();
	}

	@DELETE
	public Response deleteUser(@QueryParam("id") Long id) {
		userService.deleteUser(id);
		return Response.ok().build();
	}

	@PUT
	public Response updateUser(@QueryParam("id") Long id, UserDto userDto) {
		return Response.accepted().entity(userService.updateUser(id, userDto)).build();
	}

}
