package com.backend.eggmorning.global.security.exception;

import com.backend.eggmorning.global.security.exception.abstraction.JwtRelatedException;

public class NoBearerTokenException extends JwtRelatedException {
    public NoBearerTokenException(){
        super("There is no bearer token");
    }
}
