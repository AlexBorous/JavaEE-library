package com.alex.library.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "categories")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String category;
	@OneToMany(mappedBy = "category", targetEntity = BookCategory.class)
	private List<BookCategory> books;
	@OneToMany(mappedBy = "category", targetEntity = AppUserCategory.class)
	private List<AppUserCategory> users;

	public Category() {
	}

	public List<BookCategory> getBooks() {
		return books;
	}

	public String getCategory() {
		return category;
	}

	public Long getId() {
		return id;
	}

	public List<AppUserCategory> getUsers() {
		return users;
	}

	public void setBooks(List<BookCategory> books) {
		this.books = books;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUsers(List<AppUserCategory> users) {
		this.users = users;
	}
}
