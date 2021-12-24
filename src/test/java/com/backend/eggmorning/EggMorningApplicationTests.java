package com.backend.eggmorning;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class EggMorningApplicationTests {
    PasswordEncoder passwordEncoder;

    @Autowired
    EggMorningApplicationTests(PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
    }

    @Test
    public void test(){
        System.out.println(convertToSnakeCase("userNo"));
    }

    private String convertToSnakeCase(final String text) {
        final String regex = "([a-z])([A-Z])";
        final String replacement = "$1_$2";
        final String newName = text
            .replaceAll(regex, replacement)
            .toLowerCase();
        return newName;
    }


}
