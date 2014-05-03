package com.starfarers.view;

import javax.validation.Valid;

import org.hibernate.validator.constraints.NotEmpty;

import com.starfarers.domain.Player;

public class PlayerView implements Comparable<PlayerView> {

	@Valid
	private Player player;

	private boolean delete = false;

	public PlayerView() {
		player = new Player("player");
	}

	public PlayerView(Player player) {
		this.player = player;
	}

	@Override
	public int compareTo(PlayerView otherPlayer) {
		int comparison = Boolean.compare(otherPlayer.isActive(), isActive());
		if (comparison == 0) {
			comparison = getName().compareTo(otherPlayer.getName());
		}
		return comparison;
	}

	public Player getPlayer() {
		return player;
	}

	public Integer getId() {
		return player.getId();
	}

	public void setId(Integer id) {
		player.setId(id);
	}

	@NotEmpty
	public String getName() {
		return player.getName();
	}

	public void setName(String name) {
		player.setName(name);
	}

	public boolean isActive() {
		return player.isActive();
	}

	public void setActive(boolean active) {
		player.setActive(active);
	}

	public boolean isDelete() {
		return delete;
	}

	public void setDelete(boolean delete) {
		this.delete = delete;
	}

	@Override
	public String toString() {
		return player.toString();
	}

}