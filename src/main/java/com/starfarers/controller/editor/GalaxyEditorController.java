package com.starfarers.controller.editor;

import java.util.Arrays;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.starfarers.domain.map.Galaxy;
import com.starfarers.domain.map.Terrain;
import com.starfarers.service.GalaxyService;
import com.starfarers.service.game.GalaxyFeatures;
import com.starfarers.service.game.GalaxyGenerator;

@Controller
public class GalaxyEditorController {

	@Autowired
	private GalaxyGenerator galaxyGenerator;

	@Autowired
	private GalaxyService galaxyService;

	@RequestMapping(value = "/editor/galaxy", method = RequestMethod.GET)
	public String newGalaxy(ModelMap model) {
		setEnvironment(model);
		GalaxyFeatures galaxyFeatures = new GalaxyFeatures(10);
		model.put("galaxyFeatures", galaxyFeatures);
		model.put("galaxy", galaxyGenerator.generate(galaxyFeatures));
		return "editor/galaxy";
	}

	@RequestMapping(value = "/editor/galaxy/{id}", method = RequestMethod.GET)
	public String viewGalaxy(@PathVariable Integer id, ModelMap model) {
		Galaxy galaxy = galaxyService.find(id);
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

	@RequestMapping(value = "/editor/galaxy/delete/{id}", method = RequestMethod.POST)
	public String deleteGalaxy(@PathVariable Integer id, ModelMap model) {
		galaxyService.remove(id);
		return "redirect:/editor/galaxy";
	}

	private void setEnvironment(ModelMap model) {
		model.put("galaxies", galaxyService.findAll());
		model.put("terrains", Arrays.asList(Terrain.values()));
	}

}