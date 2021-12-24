package com.backend.eggmorning.global.security.service.inf;

import com.backend.eggmorning.domain.user.entity.User;
import com.backend.eggmorning.global.security.exception.InvalidJwtTokenException;

import java.util.Map;

public interface JwtService {
    String createToken(User user);
    String createRefreshToken(User user);
    Map<String, Object> parseTokenClaim(String token) throws InvalidJwtTokenException;
}
