package com.starfarers.controller.editor;

import javax.validation.Valid;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.starfarers.domain.map.Galaxy;
import com.starfarers.domain.map.Sector;
import com.starfarers.service.GalaxyService;

@Controller
@RequestMapping("/editor/galaxy/save")
public class SaveGalaxyController {

	private final static Logger logger = Logger.getLogger(SaveGalaxyController.class.getName());

	@Autowired
	private GalaxyService galaxyService;

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Integer saveGalaxy(@Valid @RequestBody Galaxy galaxy, BindingResult result) {
		if (result.hasErrors()) {
			return null;
		}
		try {
			for (Sector sector : galaxy.getSectors()) {
				sector.setGalaxy(galaxy);
			}
			galaxy = galaxyService.save(galaxy);
		} catch (Exception e) {
			logger.warn("Failed to save galaxy: " + e.getMessage());
			return null;
		}
		return galaxy.getId();
	}

}