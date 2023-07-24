package com.springapp.inventoryapi.enums;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springapp.inventoryapi.model.User;
import com.springapp.inventoryapi.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService userService;

	@PostMapping("/user/login")
	public User login(Principal principal) {
		String username = principal.getName();
		return (User) userService.loadUserByUsername(username);
	}
}
