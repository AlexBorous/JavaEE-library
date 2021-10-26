package com.alex.library.dto;

public class ReviewDto  {
	private Long user_id;
	private Long book_id;
	private Integer value;
	private String comment;

	public Long getBook_id() {
		return book_id;
	}

	public Long getUser_id() {
		return user_id;
	}

	public Integer getValue() {
		return value;
	}

	public ReviewDto() {
		// TODO Auto-generated constructor stub
	}

	public ReviewDto(Long user_id, Long book_id, Integer value,String comment) {
		this.user_id = user_id;
		this.book_id = book_id;
		this.value = value;
		this.comment = comment;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
