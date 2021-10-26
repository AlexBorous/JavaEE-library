package com.alex.library.model;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "users")
public class AppUser {
	@Id
	private Long id;
	private String password;
	private String username;
	@OneToMany(mappedBy = "appUser", cascade = CascadeType.ALL, targetEntity = Review.class)
	@JsonIgnore
	private List<Review> reviews = new ArrayList<>();
	@OneToMany(mappedBy = "appUser", cascade = CascadeType.ALL, targetEntity = AppUserCategory.class)
	@JsonIgnore
	private List<AppUserCategory> appUserCategories = new ArrayList<>();
	private Timestamp create_time;

	public AppUser(Long id, String username, String password) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.create_time = Timestamp.from(Instant.now());
	}

	public AppUser() {
	}

	public Long getId() {
		return id;
	}

	public List<AppUserCategory> getAppUserCategories() {
		return appUserCategories;
	}

	public String getPassword() {
		return password;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public String getUsername() {
		return username;
	}

	public Timestamp getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Timestamp create_time) {
		this.create_time = create_time;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public void setAppUserCategories(List<AppUserCategory> appUserCategories) {
		this.appUserCategories = appUserCategories;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return String.format("User: %d | name: %s | pass: %s |", id, username, password);
	}
}
