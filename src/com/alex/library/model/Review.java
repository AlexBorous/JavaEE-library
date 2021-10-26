package com.alex.library.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reviews")
public class Review {
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private Long id;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private AppUser appUser;
	@ManyToOne
	@JoinColumn(name = "book_id")
	private Book book;
	private String comment;
	private int value;

	public Review() {
	}
	
	public AppUser getAppUser() {
		return appUser;
	}

	public Book getBook() {
		return book;
	}

	public String getComment() {
		return comment;
	}

	public Long getId() {
		return id;
	}

	public int getValue() {
		return value;
	}

	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
