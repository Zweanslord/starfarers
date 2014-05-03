package com.starfarers.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.starfarers.service.PlayerService;
import com.starfarers.view.PlayerList;

@Controller
@RequestMapping("/players")
public class PlayerController {

	@Autowired
	private PlayerService playerService;

	@RequestMapping(method = RequestMethod.GET)
	public String showPlayers(ModelMap model) {
		model.addAttribute("playerList", new PlayerList(playerService.getPlayers()));
		return "players";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String savePlayers(@Valid @ModelAttribute PlayerList playerList, BindingResult result, ModelMap model, RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			return "players";
		}
		boolean success = true;
		try {
			playerService.removePlayers(playerList.getPlayersToDelete());
			playerService.savePlayers(playerList.getPlayersToSave());
		} catch (Exception e) {
			success = false;
			model.addAttribute("success", success);
			return "players";
		}
		redirectAttributes.addFlashAttribute("success", true);
		model.addAttribute("success", success);

		return "redirect:/players";
	}

	@RequestMapping(params = "add", method = RequestMethod.POST)
	public String addPlayer(@ModelAttribute PlayerList playerList, ModelMap model) {
		model.addAttribute("playerList", playerList.addNewPlayer());
		return "players";
	}

}