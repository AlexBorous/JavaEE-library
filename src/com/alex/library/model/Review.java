package com.alex.library.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "reviews")
@Data
@AllArgsConstructor
public class Review {
	@Id
	private Long id;
	@ManyToOne
	@JoinColumn(name = "student_id")
	private AppUser appUser;
	@ManyToOne
	@JoinColumn(name = "book_id")
	private Book book;
	private String comment;
	private int value;
}
