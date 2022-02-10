package com.backend.eggmorning.domain.user.controller;

import com.backend.eggmorning.domain.user.entity.User;
import com.backend.eggmorning.domain.user.service.inf.UserService;
import com.backend.eggmorning.global.network.Response;
import com.backend.eggmorning.global.security.annotation.RoleAdmin;
import com.backend.eggmorning.global.security.annotation.RoleViewer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	UserService userService;

	public UserController(UserService userService){
		this.userService = userService;
	}

	@RoleAdmin
	@PostMapping("user")
	public ResponseEntity<Boolean> createUser(@RequestParam("id")String id, @RequestParam("password")String password){
		this.userService.createUser(new User(id, password));
		return Response.success(true);
	}

	@RoleViewer
	@GetMapping("user")
	public ResponseEntity<User> getUser(@RequestParam("email") String email){
		User user =this.userService.getUserByEmail(email);
		return Response.success(user);
	}
}
