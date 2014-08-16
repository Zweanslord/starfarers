package com.starfarers.view;

import java.util.ArrayList;
import java.util.List;

import com.starfarers.domain.user.Role;
import com.starfarers.domain.user.User;

public class UserList {

	private List<User>  players = new ArrayList<>(), 
						gms = new ArrayList<>(),
						admins = new ArrayList<>(), 
						inactives = new ArrayList<>();

	public UserList(List<User> users) {
		for (User user : users) {
			if (!user.isEnabled()) {
				inactives.add(user);
			} else if (user.has(Role.ADMINISTRATOR)) {
				admins.add(user);
			} else if (user.has(Role.GAME_MASTER)) {
				gms.add(user);
			} else if (user.has(Role.PLAYER)) {
				players.add(user);
			}
		}
	}

	public List<User> getPlayers() {
		return players;
	}

	public List<User> getGms() {
		return gms;
	}

	public List<User> getAdmins() {
		return admins;
	}

	public List<User> getInactives() {
		return inactives;
	}

}