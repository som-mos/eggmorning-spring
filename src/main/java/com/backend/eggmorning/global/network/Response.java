package com.backend.eggmorning.global.network;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Response<T> {
    public static <T> ResponseEntity<T> success(T data){
        return ResponseEntity.ok(data);
    }

    public static <T> ResponseEntity<T> error(T data){
        return ResponseEntity.badRequest().body(data);
    }

    public static <T> ResponseEntity<T> unauthorized(T data){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(data);
    }
}
