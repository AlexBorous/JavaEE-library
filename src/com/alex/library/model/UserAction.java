package com.alex.library.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "users_actions")
@Data
@AllArgsConstructor
public class UserAction {
	@Id
	private Long id;
	@ManyToOne()
	@JoinColumn(name = "user_id")
	private AppUser appUser;
	private String log;
}
