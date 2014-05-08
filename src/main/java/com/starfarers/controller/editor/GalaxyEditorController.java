package com.starfarers.controller.editor;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.starfarers.service.game.GalaxyFeatures;
import com.starfarers.service.game.GalaxyGenerator;

@Controller
@RequestMapping("/editor/galaxy")
public class GalaxyEditorController {

	@Autowired
	private GalaxyGenerator galaxyGenerator;

	@RequestMapping(method = RequestMethod.GET)
	public String viewGalaxy(ModelMap model) {
		GalaxyFeatures galaxyFeatures = new GalaxyFeatures(10);
		model.put("galaxyFeatures", galaxyFeatures);
		model.put("galaxy", galaxyGenerator.generate(galaxyFeatures));
		return "editor/galaxy";
	}

	@RequestMapping(params = "generate", method = RequestMethod.POST)
	public String generateGalaxy(@Valid @ModelAttribute GalaxyFeatures galaxyFeatures, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "editor/galaxy";
		}
		model.put("galaxy", galaxyGenerator.generate(galaxyFeatures));
		return "editor/galaxy";
	}

}