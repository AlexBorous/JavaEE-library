package com.alex.library.model;

import java.sql.Date;
import java.time.Instant;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "books")
public class Book {
	@Id
	private Long id;
	private String author;
	private String description;
	private String title;
	private Date release_date = new Date(java.util.Date.from(Instant.now()).getTime());
	@OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Review> reviews;
	@OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<BookCategory> bookCategories;

	public Book() {
		// TODO Auto-generated constructor stub
	}

	public String getAuthor() {
		return author;
	}

	public List<BookCategory> getBookCategories() {
		return bookCategories;
	}

	public String getDescription() {
		return description;
	}

	public Long getId() {
		return id;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public String getTitle() {
		return title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setBookCategories(List<BookCategory> bookCategories) {
		this.bookCategories = bookCategories;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getRelease_date() {
		return release_date;
	}

	public void setRelease_date(Date release_date) {
		this.release_date = release_date;
	}

}
