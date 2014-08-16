package com.starfarers.controller.admin.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.starfarers.service.user.UserService;

@Controller
@RequestMapping("/admin/user/password")
public class ResetPasswordController {

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public String confirmResetPassword(@RequestParam String name, ModelMap model) {
		model.addAttribute("user", userService.find(name));
		return "admin/user/password";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String resetPassword(@RequestParam String name, ModelMap model, RedirectAttributes redirectAttributes) {
		try {
			userService.resetPassword(name);
		} catch (Exception e) {
			model.addAttribute("success", false);
			return "admin/user/password";
		}

		redirectAttributes.addFlashAttribute("password", name);
		return "redirect:/admin/user";
	}

}
