package com.starfarers.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/master")
public class MasterController {

	@RequestMapping
	public String main() {
		return "master";
	}

}