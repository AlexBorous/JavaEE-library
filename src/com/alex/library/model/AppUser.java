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
@Table(name="users")
@Data
@AllArgsConstructor
public class AppUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String password;
	private String username;
    @OneToMany(mappedBy = "users")
	private List<Review> reviews;
    @OneToMany(mappedBy = "users")
    private List<AppUserCategory> appUserCategories;
}
