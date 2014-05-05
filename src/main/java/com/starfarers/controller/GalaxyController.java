package com.starfarers.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.starfarers.service.game.GalaxyGenerator;

@Controller
@RequestMapping("/galaxy")
public class GalaxyController {

	@RequestMapping
	public String viewGalaxy(ModelMap model) {
		model.put("galaxy", new GalaxyGenerator(10).generate());
		return "galaxy";
	}

}
