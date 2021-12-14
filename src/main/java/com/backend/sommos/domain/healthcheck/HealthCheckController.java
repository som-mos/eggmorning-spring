package com.backend.sommos.domain.healthcheck;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

    @ResponseBody
    @RequestMapping("hc")
    public String healthCheck(){
        return "true";
    }
}
