package com.alex.library.dto;

import java.io.Serializable;

public class BookDto implements Serializable {
	private String title;
	private String author;
	private String description;

	public String getAuthor() {
		return author;
	}

	public String getDescription() {
		return description;
	}

	public String getTitle() {
		return title;
	}

	public BookDto() {
		// TODO Auto-generated constructor stub
	}

	public BookDto(String title, String author, String description) {
		this.title = title;
		this.author = author;
		this.description = description;
	}
}
