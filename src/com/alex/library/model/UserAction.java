package com.alex.library.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users_actions")
public class UserAction {
	@Id
	private Long id;
	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "user_id")
	private AppUser appUser;
	private String log;

	public UserAction() {
		// TODO Auto-generated constructor stub
	}

	public AppUser getAppUser() {
		return appUser;
	}

	public Long getId() {
		return id;
	}

	public String getLog() {
		return log;
	}

	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setLog(String log) {
		this.log = log;
	}

}
