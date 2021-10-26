package com.alex.library.controller;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import com.alex.library.dto.CategoryDto;

@Path("/categories")
public class CategoryController {
	@POST
	public void addCategory(CategoryDto categoryDto) {
		
	}
}
