package com.alex.library.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "users_preferences")
public class AppUserCategory {
	@GeneratedValue
	@Id
	private Long id;
	@ManyToOne
	@JoinColumn(name = "category_id")
	@JsonIgnore
	private Category category;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private AppUser appUser;

	public AppUser getAppUser() {
		return appUser;
	}

	public Category getCategory() {
		return category;
	}

	public Long getId() {
		return id;
	}

	public AppUserCategory() {
		// TODO Auto-generated constructor stub
	}

	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
