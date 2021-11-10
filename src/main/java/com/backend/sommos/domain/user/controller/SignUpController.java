package com.backend.sommos.domain.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.backend.sommos.domain.user.entity.User;
import com.backend.sommos.domain.user.service.inf.SignUpService;

@Controller
public class SignUpController {
	SignUpService signUpService;

	@Autowired
	public SignUpController(@Qualifier("signUpService") SignUpService signUpService){
		this.signUpService = signUpService;
	}

	@ResponseBody
	@PostMapping("user")
	public boolean createUser(@RequestParam("id")String id, @RequestParam("password")String password){
		return this.signUpService.signUp(new User(id, password));
	}

	@ResponseBody
	@GetMapping("user")
	public String test(){
		return "test";
	}
}
