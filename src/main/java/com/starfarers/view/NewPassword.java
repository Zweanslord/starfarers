package com.starfarers.view;

import javax.validation.constraints.Size;

import com.starfarers.validation.PasswordsMatch;

@PasswordsMatch
public class NewPassword {

	@Size(min = 8, max = 200)
	private String password = "";

	private String passwordConfirmation = "";

	public NewPassword() {
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}

}