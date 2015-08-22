package com.starfarers.controller.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.starfarers.domain.species.Species;
import com.starfarers.service.SpeciesService;
import com.starfarers.service.user.UserService;

@Controller
@RequestMapping(value = "/player/species/create")
public class CreateSpeciesController {

	@Autowired
	private transient UserService userService;

	@Autowired
	private transient SpeciesService speciesService;

	@RequestMapping
	public String create(ModelMap model) {
		model.addAttribute("species", new Species());
		return "player/species/create";
	}

}