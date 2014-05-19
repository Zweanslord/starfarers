package com.starfarers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.starfarers.service.game.StarGenerator;

@Controller
@RequestMapping("/star")
public class StarController {

	@Autowired
	private transient StarGenerator starGenerator;

	@RequestMapping
	public String showStarSystem(ModelMap model) {
		model.addAttribute("star", starGenerator.generate());
		return "star";
	}

}