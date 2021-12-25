package com.backend.eggmorning.global.security.exception.abstraction;

public abstract class JwtRelatedException extends RuntimeException {
	public JwtRelatedException(String msg){
		super(msg);
	}
}
