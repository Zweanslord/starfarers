package com.starfarers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.starfarers.service.PlayerService;

@Controller
@RequestMapping("/players")
public class PlayersController {

	@Autowired
	private PlayerService playerService;

	@RequestMapping
	public String showPlayers(ModelMap model) {
		model.addAttribute("players", playerService.getActivePlayers());
		model.addAttribute("inactivePlayers", playerService.getInactivePlayers());
		return "players";
	}
}