package com.starfarers.controller.editor;

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
public class StarSelectorController {

	@Autowired
	private transient GalaxyService galaxyService;

	@RequestMapping(value = "/editor/starSelector")
	public String newGalaxy(ModelMap model) {
		setEnvironment(model);
		model.put("galaxy", galaxyService.findOne());
		return "editor/starSelector";
	}

	@RequestMapping(value = "/editor/starSelector/{galaxyId}")
	public String viewGalaxy(@PathVariable Integer galaxyId, ModelMap model) {
		setEnvironment(model);
		model.put("galaxy", galaxyService.find(galaxyId));
		return "editor/starSelector";
	}

	private void setEnvironment(ModelMap model) {
		model.put("galaxies", galaxyService.findAll());
		model.put("terrains", Arrays.asList(Terrain.values()));
	}

}