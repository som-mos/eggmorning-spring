package com.backend.eggmorning.global.advice;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.backend.eggmorning.global.network.Response;
import com.backend.eggmorning.global.security.exception.abstraction.JwtRelatedException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class EggMorningControllerAdvice {

	@ExceptionHandler(JwtRelatedException.class)
	public ResponseEntity handleJwtRelatedAuthentication(JwtRelatedException e){
		logHandleException(e);
		return Response.unauthorized(e.getMessage());
	}

	@ExceptionHandler(BadCredentialsException.class)
	public ResponseEntity handleBadCredentialsException(BadCredentialsException e){
		logHandleException(e);
		return Response.error("Bad Credential");
	}

	private void logHandleException(Exception e){
		StringBuilder errMsg = new StringBuilder();
		StackTraceElement lastStackElement = e.getStackTrace()[0];
		errMsg.append(e.getClass().getSimpleName()).append(" is handled :: Msg: ").append(e.getMessage()).append(" / Occurred at: ").append(lastStackElement.getClassName()).append(".").append(lastStackElement.getMethodName());
		log.warn(errMsg.toString());
	}
}
