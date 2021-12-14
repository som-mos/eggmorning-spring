package com.backend.sommos.global.constant;

import lombok.Getter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Getter
public enum Role {
    ADMIN("ROLE_ADMIN"), VIEWER("ROLE_VIEWER"), REFRESH("ROLE_REFRESH"), UNKNOWN("Unknown");

    String name;
    Role(String name){
        this.name = name;
    }

    private static Map<String, Role> nameRoleMap = Collections.unmodifiableMap(Arrays.stream(values()).collect(Collectors.toMap(role->role.name, Function.identity())));

    public SimpleGrantedAuthority getAuthority(){
        return new SimpleGrantedAuthority(this.name);
    }

    public static Role findByName(String name){
        return Optional.ofNullable(nameRoleMap.get(name)).orElse(UNKNOWN);
    }
}
