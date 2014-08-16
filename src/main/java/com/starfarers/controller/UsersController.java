package com.starfarers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.starfarers.service.user.UserService;
import com.starfarers.view.UserList;

@Controller
@RequestMapping("/users")
public class UsersController {

	@Autowired
	private transient UserService userService;

	@RequestMapping
	public String users(ModelMap model) {
		model.addAttribute("userList", new UserList(userService.findAll()));
		return "users";
	}

}
