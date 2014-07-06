package com.starfarers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.starfarers.service.PlayerService;
import com.starfarers.view.PlayerList;

@Controller
@RequestMapping("/players")
public class PlayersController {

	@Autowired
	private PlayerService playerService;

	@RequestMapping
	public String showPlayers(ModelMap model) {
		model.addAttribute("playerList", new PlayerList(playerService.getActivePlayers()));
		model.addAttribute("inactivePlayerList", new PlayerList(playerService.getInactivePlayers()));
		return "players";
	}
}