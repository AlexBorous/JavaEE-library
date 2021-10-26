package com.alex.library.filter;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

import org.jboss.logging.Logger;

@Provider
public class LoggerFilter implements ContainerResponseFilter {
	static Logger logger = Logger.getLogger(LoggerFilter.class);

	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
			throws IOException {
		logger.info("Path: " + requestContext.getUriInfo().getPath() + " Request Uri: "
				+ requestContext.getUriInfo().getRequestUri() + " Method: " + requestContext.getMethod());

		logger.info("Status: " + responseContext.getStatus());
		logger.info("Entity: " + responseContext.getEntity());

		return;
	}

}
