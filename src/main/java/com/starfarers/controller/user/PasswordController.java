package com.starfarers.controller.user;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.starfarers.domain.user.User;
import com.starfarers.service.user.SecurityService;
import com.starfarers.service.user.UserService;
import com.starfarers.view.NewPassword;

@Controller
@RequestMapping("/user/password")
public class PasswordController {

	@Autowired
	private transient UserService userService;

	@Autowired
	private transient SecurityService securityService;

	@RequestMapping(method = RequestMethod.GET)
	public String newPassword(ModelMap model, @AuthenticationPrincipal User user) {
		model.addAttribute("newPassword", new NewPassword());
		return "/user/password";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String setPassword(@Valid @ModelAttribute NewPassword newPassword, BindingResult result, ModelMap model, RedirectAttributes redirectAttributes,
			@AuthenticationPrincipal User user) {
		if (result.hasErrors()) {
			return "user/password";
		}

		user.setPassword(securityService.encode(newPassword.getPassword()));

		try {
			userService.save(user);
		} catch (Exception e) {
			model.addAttribute("success", false);
			return "user/password";
		}

		redirectAttributes.addFlashAttribute("password", true);
		return "redirect:/user";
	}

}
