package com.backend.eggmorning.domain.hc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.eggmorning.global.security.annotation.Public;

@RestController
public class HealthCheckController {

    @Public
    @GetMapping("hc")
    public String healthCheck(){
        return "true";
    }
}
