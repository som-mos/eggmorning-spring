package com.backend.eggmorning.global.exceptions;

import com.backend.eggmorning.global.exceptions.handler.InvalidTokenException;

public class NoTokenException extends InvalidTokenException {

	public NoTokenException() {
		super("null");
	}
}
