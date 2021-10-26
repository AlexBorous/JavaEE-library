package com.alex.library.converter;

import java.util.concurrent.ThreadLocalRandom;

import javax.ejb.Stateless;

import org.mindrot.jbcrypt.BCrypt;

import com.alex.library.dto.UserDto;
import com.alex.library.model.AppUser;

@Stateless
public class UserDtoToAppUserConverter {

	public AppUser convert(UserDto userDto) {
		String plainPassword = userDto.getPassword();
		String hashed = BCrypt.hashpw(plainPassword, BCrypt.gensalt());
		int randomNum = ThreadLocalRandom.current().nextInt(0, 5000 + 1);
		return new AppUser((long) randomNum, userDto.getName(), hashed);
	}
}
