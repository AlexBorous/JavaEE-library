package com.alex.library.dto;

public class UserDto {
	private String name;
	private String password;

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public UserDto() {
		// TODO Auto-generated constructor stub
	}

	public UserDto(String name, String password) {
		this.name = name;
		this.password = password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}
