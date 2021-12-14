package com.backend.sommos.global.security.exception;

public class InvalidJwtTokenException extends Exception {
    public InvalidJwtTokenException(){
        super("Token is invalid");
    }
}
