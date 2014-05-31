package com.starfarers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.starfarers.domain.map.Coordinates;
import com.starfarers.service.StarService;
import com.starfarers.service.game.StarGenerator;

@Controller
@RequestMapping
public class StarController {

	@Autowired
	private transient StarGenerator starGenerator;

	@Autowired
	private transient StarService starService;

	@RequestMapping("/star")
	public String showStarSystem(ModelMap model) {
		model.addAttribute("star", starGenerator.generate(null));
		return "star";
	}

	@RequestMapping("/star/{galaxy}/{x}/{y}")
	public String findStarSystem(@PathVariable Integer galaxy, @PathVariable Integer x, @PathVariable Integer y, ModelMap model) {
		model.addAttribute("star", starService.findStarByGalaxyIdAndCoordinates(galaxy, new Coordinates(x, y)));
		return "star";
	}

}