package com.starfarers.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.starfarers.domain.map.Terrain;
import com.starfarers.service.GalaxyService;

@Controller
@RequestMapping
public class GalaxyController {

	@Autowired
	private transient GalaxyService galaxyService;

	@RequestMapping("/galaxy")
	public String viewGalaxy(ModelMap model) {
		model.put("terrains", Arrays.asList(Terrain.values()));
		model.put("galaxy", galaxyService.findOne());
		return "galaxy";
	}

	@RequestMapping("/galaxy/{galaxy}")
	public String findGalaxy(@PathVariable Integer galaxy, ModelMap model) {
		model.put("terrains", Arrays.asList(Terrain.values()));
		model.put("galaxy", galaxyService.find(galaxy));
		return "galaxy";
	}

}