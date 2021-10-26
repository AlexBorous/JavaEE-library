	package com.alex.library.dto;

public class CategoryDto {
	private Long book_id;
	private Long user_id;
	private String category;

	public Long getBook_id() {
		return book_id;
	}

	public String getCategory() {
		return category;
	}

	public Long getUser_id() {
		return user_id;
	}

	public CategoryDto() {
		// TODO Auto-generated constructor stub
	}

	public CategoryDto(Long book_id, Long user_id, String category) {
		this.book_id = book_id;
		this.user_id = user_id;
		this.category = category;
	}
}
