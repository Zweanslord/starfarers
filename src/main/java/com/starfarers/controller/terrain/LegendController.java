package com.starfarers.controller.terrain;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.starfarers.domain.map.Terrain;

@Controller
@RequestMapping
public class LegendController {

	@RequestMapping("/terrain/legend")
	public String viewGalaxy(ModelMap model) {
		model.put("terrains", Arrays.asList(Terrain.values()));
		return "terrain/legend";
	}

}
