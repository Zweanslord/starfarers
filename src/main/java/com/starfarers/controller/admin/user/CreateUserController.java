package com.starfarers.controller.admin.user;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.starfarers.domain.user.Role;
import com.starfarers.domain.user.User;
import com.starfarers.service.user.UserService;

@Controller
@RequestMapping("/admin/user/create")
public class CreateUserController {

	private static final Logger logger = LogManager.getLogger(CreateUserController.class);

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public String newUser(ModelMap model) {
		model.addAttribute("user", userService.create());
		model.addAttribute("roles", Role.values());
		return "admin/user/create";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String createUser(@Valid @ModelAttribute User user, BindingResult result, ModelMap model, RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			model.addAttribute("roles", Role.values());
			return "admin/user/create";
		}

		try {
			userService.create(user);
		} catch (Exception e) {
			logger.error("Failed to create user {}: {}", user.getUsername(), e.getMessage());
			model.addAttribute("roles", Role.values());
			model.addAttribute("success", false);
			return "admin/user/create";
		}

		redirectAttributes.addFlashAttribute("created", user.getUsername());
		return "redirect:/admin/user";
	}

}