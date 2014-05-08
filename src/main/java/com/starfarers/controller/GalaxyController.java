package com.starfarers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.starfarers.service.game.GalaxyFeatures;
import com.starfarers.service.game.GalaxyGenerator;

@Controller
@RequestMapping("/galaxy")
public class GalaxyController {

	@Autowired
	private GalaxyGenerator galaxyGenerator;

	@RequestMapping
	public String viewGalaxy(ModelMap model) {
		model.put("galaxy", galaxyGenerator.generate(new GalaxyFeatures(10)));
		return "galaxy";
	}

}