package com.starfarers.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.starfarers.service.user.UserService;

@Controller
@RequestMapping(value = "/admin/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping
	public String showUser(ModelMap model) {
		model.addAttribute("users", userService.findAll());
		return "admin/user";
	}

}