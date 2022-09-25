package com.backend.eggmorning.global.exceptions;

import com.backend.eggmorning.global.exceptions.handler.InvalidTokenException;

public class InvalidAccessTokenException extends InvalidTokenException {

	public InvalidAccessTokenException(String token) {
		super(token);
	}
}
