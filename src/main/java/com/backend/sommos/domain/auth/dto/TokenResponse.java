package com.backend.sommos.domain.auth.dto;

import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Getter
@Builder
public class TokenResponse {
    private String jwtToken;
    private String refreshToken;
}
