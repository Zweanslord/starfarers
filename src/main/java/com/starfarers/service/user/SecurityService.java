package com.starfarers.service.user;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SecurityService {

	private static final PasswordEncoder encoder = new BCryptPasswordEncoder();

	public String encode(String password) {
		return encoder.encode(password);
	}

	protected boolean matches(String encoded, String password) {
		return encoder.matches(password, encoded);
	}

}