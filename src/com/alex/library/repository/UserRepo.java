package com.alex.library.repository;

import java.util.List;

import com.alex.library.model.AppUser;

public interface UserRepo {
	AppUser getUserById(Long id);
	
	AppUser getUserByName(String name);
	
	AppUser getUserByNameAndPassword(String name,String password);

	AppUser saveUser(AppUser appUser);

	AppUser updateUser(AppUser appUser);

	void deleteUser(Long id);

	List<AppUser> getAll();
}
