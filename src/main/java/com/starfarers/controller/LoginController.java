package com.starfarers.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class LoginController {

	@RequestMapping("/login")
	public String login(ModelMap model) {
		return "login";
	}

}