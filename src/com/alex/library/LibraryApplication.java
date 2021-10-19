package com.alex.library;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.alex.library.controller.BookController;
import com.alex.library.controller.ReviewController;
import com.alex.library.controller.UserController;

@ApplicationPath("/rest")
public class LibraryApplication extends Application {

	private Set<Object> singletons = new HashSet<Object>();

	public LibraryApplication() {
		singletons.add(new BookController());
		singletons.add(new UserController());
		singletons.add(new ReviewController());
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}
