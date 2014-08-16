package com.starfarers.configuration;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.starfarers.domain.user.User;
import com.starfarers.service.user.UserService;

@Component
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

	LoginSuccessHandler() {
		super();
		super.setTargetUrlParameter("redirect");
	}

	@Autowired
	private transient UserService userService;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException,
			IOException {
		if (userService.hasDefaultPassword((User) authentication.getPrincipal())) {
			String targetUrl = "/user/password?needNew";
			getRedirectStrategy().sendRedirect(request, response, targetUrl);
		} else {
			super.onAuthenticationSuccess(request, response, authentication);
		}
	}

}
