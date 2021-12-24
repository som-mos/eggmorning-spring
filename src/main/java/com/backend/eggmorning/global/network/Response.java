package com.backend.eggmorning.global.network;

import org.springframework.http.ResponseEntity;

public class Response<T> {
    public static <T> ResponseEntity<T> success(T data){
        return ResponseEntity.ok(data);
    }
}
