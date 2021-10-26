package com.alex.library.exception;

public class NoUserException extends RuntimeException {
	public NoUserException(String message, Throwable cause) {
		super(message, cause);
	}
}
