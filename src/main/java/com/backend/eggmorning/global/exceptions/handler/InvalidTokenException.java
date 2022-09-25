package com.backend.eggmorning.global.exceptions.handler;

public abstract class InvalidTokenException extends RuntimeException {
	protected InvalidTokenException(String token) {
		super(String.format("Token: %s is invalid", token));
	}
}
