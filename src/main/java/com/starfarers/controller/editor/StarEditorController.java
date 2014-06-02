package com.starfarers.controller.editor;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.starfarers.domain.map.Coordinates;
import com.starfarers.domain.map.system.PlanetType;
import com.starfarers.domain.map.system.Star;
import com.starfarers.service.StarService;
import com.starfarers.service.game.PlanetGenerator;

@Controller
@RequestMapping
public class StarEditorController {

	@Autowired
	private transient StarService starService;

	@Autowired
	private transient PlanetGenerator planetGenerator;

	@RequestMapping(value = "/editor/star/{galaxy}/{x}/{y}", method = RequestMethod.GET)
	public String showStarSystem(@PathVariable Integer galaxy, @PathVariable Integer x, @PathVariable Integer y, ModelMap model) {
		model.addAttribute("star", starService.findStarByGalaxyIdAndCoordinates(galaxy, new Coordinates(x, y)));
		setEnvironment(model);
		return "editor/star";
	}

	@RequestMapping(value = "/editor/star/{galaxy}/{x}/{y}", method = RequestMethod.POST)
	public String saveStarSystem(@PathVariable Integer galaxy, @PathVariable Integer x, @PathVariable Integer y, @Valid @ModelAttribute Star star,
			BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "editor/star";
		}
		model.addAttribute("star", starService.save(galaxy, new Coordinates(x, y), star));
		setEnvironment(model);
		return "editor/star";
	}

	@RequestMapping(value = "/editor/star/{galaxy}/{x}/{y}", params = "add", method = RequestMethod.POST)
	public String addPlanet(@PathVariable Integer galaxy, @PathVariable Integer x, @PathVariable Integer y, @ModelAttribute Star star, ModelMap model) {
		star.addPlanet(planetGenerator.generate(star));
		model.addAttribute("star", star);
		setEnvironment(model);
		return "editor/star";
	}

	@RequestMapping(value = "/editor/star/{galaxy}/{x}/{y}", params = "remove", method = RequestMethod.POST)
	public String removePlanet(@PathVariable Integer galaxy, @PathVariable Integer x, @PathVariable Integer y, @RequestParam Integer position,
			@ModelAttribute Star star, ModelMap model) {
		star.removePlanet(position);
		model.addAttribute("star", star);
		setEnvironment(model);
		return "editor/star";
	}

	private void setEnvironment(ModelMap model) {
		model.addAttribute("planetTypes", PlanetType.values());
	}

}