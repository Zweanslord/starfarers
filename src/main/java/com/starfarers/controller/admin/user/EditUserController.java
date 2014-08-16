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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.starfarers.domain.user.Role;
import com.starfarers.domain.user.User;
import com.starfarers.service.user.UserService;

@Controller
@RequestMapping("/admin/user/edit")
public class EditUserController {

	private static final Logger logger = LogManager.getLogger(CreateUserController.class);

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public String editUser(@RequestParam String name, ModelMap model) {
		model.addAttribute("user", userService.find(name));
		model.addAttribute("roles", Role.values());
		return "admin/user/edit";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String editUser(@Valid @ModelAttribute User user, BindingResult result, ModelMap model, RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			model.addAttribute("roles", Role.values());
			return "admin/user/edit";
		}

		user = update(user);

		try {
			userService.save(user);
		} catch (Exception e) {
			logger.error("Failed to edit user {}: {}", user.getUsername(), e.getMessage());
			model.addAttribute("roles", Role.values());
			model.addAttribute("success", false);
			return "admin/user/edit";
		}

		redirectAttributes.addFlashAttribute("edited", user.getUsername());
		return "redirect:/admin/user";
	}

	private User update(User user) {
		User originalUser = userService.find(user.getId());
		originalUser.setUsername(user.getUsername());
		originalUser.setRoles(user.getRoles());
		originalUser.setEnabled(user.isEnabled());
		return originalUser;
	}

}