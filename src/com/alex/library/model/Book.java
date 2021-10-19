package com.alex.library.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;

import lombok.Data;

@Entity
@Table(name = "books")
@Data
@AllArgsConstructor
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String author;
	private String description;
	private String title;
	@OneToMany(mappedBy = "books")
	private List<Review> reviews;
	@OneToMany(mappedBy = "books")
	private List<BookCategory> bookCategories;
}
