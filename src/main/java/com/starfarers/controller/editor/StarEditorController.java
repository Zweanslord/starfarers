package com.starfarers.controller.editor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.starfarers.domain.map.system.PlanetType;
import com.starfarers.service.game.StarGenerator;

@Controller
@RequestMapping
public class StarEditorController {

	@Autowired
	private transient StarGenerator starGenerator;

	@RequestMapping("/editor/star")
	public String showStarSystem(ModelMap model) {
		model.addAttribute("star", starGenerator.generate(null));
		model.addAttribute("planetTypes", PlanetType.values());
		return "editor/star";
	}

}
