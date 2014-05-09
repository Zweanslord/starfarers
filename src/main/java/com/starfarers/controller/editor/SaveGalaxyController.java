package com.starfarers.controller.editor;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.starfarers.dao.GalaxyDao;
import com.starfarers.domain.map.Galaxy;
import com.starfarers.domain.map.Sector;

@Controller
@RequestMapping("/editor/galaxy/save")
public class SaveGalaxyController {

	@Autowired
	private GalaxyDao galaxyDao;

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
			galaxy = galaxyDao.save(galaxy);
		} catch (Exception e) {
			return null;
		}
		return galaxy.getId();
	}

}