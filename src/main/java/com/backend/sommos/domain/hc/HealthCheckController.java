package com.backend.sommos.domain.hc;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {
    @RequestMapping("hc")
    public String healthCheck(){
        return "true";
    }
}
