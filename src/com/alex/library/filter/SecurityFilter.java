package com.alex.library.filter;

import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import javax.ejb.EJB;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.jboss.logging.Logger;
import org.jboss.resteasy.util.Base64;

import com.alex.library.dto.UserDto;
import com.alex.library.service.UserService;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.JWTVerifier;

@Provider
public class SecurityFilter implements ContainerRequestFilter {
	static Logger logger = Logger.getLogger(SecurityFilter.class);

	@EJB
	private UserService userService;
	private static final String AUTHORIZATION_HEADER = "Authorization";
	private static final String BASIC_AUTH_PREFIX = "Basic ";
	private static final String BEARER_AUTH_PREFIX = "Bearer ";
	private static final String REGISTER_ENDPOINT = "/users/register";
	private static final String LOGIN_ENDPOINT = "/users/login";

	Response unauthResponse = Response.status(Response.Status.UNAUTHORIZED).entity("Check your credentials").build();

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		if (requestContext.getUriInfo().getPath().contains(REGISTER_ENDPOINT))
			return;
		if (requestContext.getUriInfo().getPath().contains(LOGIN_ENDPOINT)) {
			List<String> authHeader = requestContext.getHeaders().get(AUTHORIZATION_HEADER);
			if (authHeader != null && authHeader.size() >= 1) {
				authenticateUser(requestContext, authHeader);
				logger.debug("User authenticated , bearer token is valid");
				return;
			}
			requestContext.abortWith(unauthResponse);
		}

		List<String> authHeader = requestContext.getHeaders().get(AUTHORIZATION_HEADER);
		if (authHeader != null && authHeader.size() >= 1) {
			String authToken = authHeader.get(0);
			authToken = authToken.replaceFirst(BEARER_AUTH_PREFIX, "");
			try {
				Algorithm algorithm = Algorithm.HMAC256("secret");
				JWTVerifier verifier = JWT.require(algorithm).withIssuer("auth0").build();
				verifier.verify(authToken);
				return;
			} catch (JWTVerificationException exception) {
				logger.error("Bearer token not valid");
				requestContext.abortWith(unauthResponse);
			}

		}
		logger.error("No Authorization header" + requestContext.getUriInfo().getPath());
		requestContext.abortWith(unauthResponse);
	}

	private void authenticateUser(ContainerRequestContext requestContext, List<String> authHeader) throws IOException {
		String authToken = authHeader.get(0);
		authToken = authToken.replaceFirst(BASIC_AUTH_PREFIX, "");
		String decoded = new String(Base64.decode(authToken));
		StringTokenizer tokenizer = new StringTokenizer(decoded, ":");
		if (tokenizer.countTokens() < 2)
			requestContext.abortWith(unauthResponse);
		String username = tokenizer.nextToken();
		String password = tokenizer.nextToken();
		if (userService.loginUser(new UserDto(username, password)) == null)
			requestContext.abortWith(unauthResponse);
		try {
			Algorithm algorithm = Algorithm.HMAC256("secret");
			String token = JWT.create().withIssuer("auth0")
					.withExpiresAt(Date.from(new Date().toInstant().plus(Duration.ofHours(1)))).sign(algorithm);
			requestContext.abortWith(Response.accepted(token).build());
		} catch (JWTCreationException exception) {
			logger.error("JWT exception : " + exception.getMessage());
			requestContext.abortWith(unauthResponse);
		}
		return;
	}
	
	

}
