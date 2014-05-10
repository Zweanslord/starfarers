package com.starfarers.controller.editor;

import java.util.Arrays;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.starfarers.dao.GalaxyDao;
import com.starfarers.domain.map.Galaxy;
import com.starfarers.domain.map.Terrain;
import com.starfarers.service.game.GalaxyFeatures;
import com.starfarers.service.game.GalaxyGenerator;

@Controller
public class GalaxyEditorController {

	@Autowired
	private GalaxyGenerator galaxyGenerator;

	@Autowired
	private GalaxyDao galaxyDao;

	@RequestMapping(value = "/editor/galaxy", method = RequestMethod.GET)
	public String newGalaxy(ModelMap model) {
		setEnvironment(model);
		GalaxyFeatures galaxyFeatures = new GalaxyFeatures(10);
		model.put("galaxyFeatures", galaxyFeatures);
		model.put("galaxy", galaxyGenerator.generate(galaxyFeatures));
		return "editor/galaxy";
	}

	@RequestMapping(value = "/editor/selectgalaxy", method = RequestMethod.GET)
	public String viewGalaxy(@RequestParam Integer id, ModelMap model) {
		Galaxy galaxy = galaxyDao.find(id);
		setEnvironment(model);
		model.put("galaxyFeatures", new GalaxyFeatures(galaxy.getRadius()));
		model.put("galaxy", galaxy);
		return "editor/galaxy";
	}

	@RequestMapping(value = "/editor/galaxy", params = "generate", method = RequestMethod.POST)
	public String generateGalaxy(@Valid @ModelAttribute GalaxyFeatures galaxyFeatures, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "editor/galaxy";
		}
		setEnvironment(model);
		model.put("galaxy", galaxyGenerator.generate(galaxyFeatures));
		return "editor/galaxy";
	}

	private void setEnvironment(ModelMap model) {
		model.put("galaxies", galaxyDao.findAll());
		model.put("terrains", Arrays.asList(Terrain.values()));
	}

}