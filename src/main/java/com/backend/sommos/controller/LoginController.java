package com.backend.sommos.controller;

import com.backend.sommos.entities.User;
import com.backend.sommos.service.impl.LoginServiceImpl;
import com.backend.sommos.service.inf.LoginService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    private LoginService loginService;

    @Autowired
    public LoginController(@Qualifier("loginService")LoginService loginService) {
        this.loginService = loginService;
    }

    @ResponseBody
    @RequestMapping("session1")
    public String login(){
        return "ok";
    }

    @ResponseBody
    @RequestMapping("signup")
    public String signup(@RequestBody User reqBody){
        return "ok";
    }
}
