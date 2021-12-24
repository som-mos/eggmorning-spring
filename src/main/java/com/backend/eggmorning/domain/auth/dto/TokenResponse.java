package com.backend.eggmorning.domain.auth.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TokenResponse {
    private String jwtToken;
    private String refreshToken;
}
