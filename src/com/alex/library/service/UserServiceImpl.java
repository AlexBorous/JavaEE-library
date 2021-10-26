package com.alex.library.service;

import java.util.List;
import java.util.Optional;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.NotFoundException;

import org.mindrot.jbcrypt.BCrypt;

import com.alex.library.converter.UserDtoToAppUserConverter;
import com.alex.library.dto.UserDto;
import com.alex.library.exception.NoUserException;
import com.alex.library.model.AppUser;
import com.alex.library.repository.UserRepo;

@Stateless
public class UserServiceImpl implements UserService {
	@EJB
	private UserRepo userRepo;

	@EJB
	private UserDtoToAppUserConverter userConverter;

	@Override
	public List<AppUser> getAllUsers() {
		return Optional.ofNullable(userRepo.getAll()).orElseThrow(() -> new NotFoundException("Error occured"));
	}

	@Override
	public AppUser getAppUserById(Long id) {
		return Optional.ofNullable(userRepo.getUserById(id))
				.orElseThrow(() -> new NotFoundException(String.format("User with id: %l not found", id)));
	}

	@Override
	public AppUser getAppUserByName(String name) {
		return userRepo.getUserByName(name);
	}

	@Override
	public void deleteUser(Long id) {
		userRepo.deleteUser(id);
	}

	@Override
	public AppUser updateUser(Long id, UserDto userDto) {
		AppUser appUser = Optional.ofNullable(getAppUserById(id))
				.orElseThrow(() -> new NoUserException("User could not be found", null));
		appUser.setUsername(userDto.getName());
		return userRepo.updateUser(appUser);
	}

	@Override
	public AppUser loginUser(UserDto userDto) {
		String password = BCrypt.hashpw(userDto.getPassword(), BCrypt.gensalt());
		return userRepo.getUserByNameAndPassword(userDto.getName(), password);
	}

	@Override
	public AppUser registerUser(UserDto userDto) {
		AppUser appUser = userConverter.convert(userDto);
		return Optional.ofNullable(userRepo.saveUser(appUser)).orElseThrow(
				() -> new NotFoundException(String.format("Error occured with registration %s", userDto.toString())));
	}

}
