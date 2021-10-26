package com.alex.library.service;

import java.util.List;

import com.alex.library.dto.UserDto;
import com.alex.library.model.AppUser;

public interface UserService {
	List<AppUser> getAllUsers();

	AppUser getAppUserById(Long id);

	AppUser getAppUserByName(String name);

	void deleteUser(Long id);

	AppUser updateUser(Long id, UserDto userDto);

	AppUser loginUser(UserDto userDto);

	AppUser registerUser(UserDto userDto);
}
