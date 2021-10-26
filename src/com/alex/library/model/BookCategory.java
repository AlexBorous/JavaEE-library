package com.alex.library.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "books_categories")
public class BookCategory {
	@GeneratedValue
	@Id
	private Long id;
	@ManyToOne
	@JoinColumn(name = "category_id")
	@JsonIgnore
	private Category category;
	@ManyToOne
	@JoinColumn(name = "book_id")
	private Book book;

	public BookCategory() {
		// TODO Auto-generated constructor stub
	}

	public Book getBook() {
		return book;
	}

	public Category getCategory() {
		return category;
	}

	public Long getId() {
		return id;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
