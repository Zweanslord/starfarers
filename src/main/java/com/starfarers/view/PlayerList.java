package com.starfarers.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.validation.Valid;

import com.starfarers.domain.Player;
import com.starfarers.validation.UniquePlayerView;

public class PlayerList {

	@UniquePlayerView
	@Valid
	private List<PlayerView> playerViews = new ArrayList<>();

	public PlayerList(List<Player> players) {
		setPlayers(players);
	}

	public PlayerList() {
	}

	public PlayerList addNewPlayer() {
		playerViews.add(new PlayerView());
		return this;
	}

	public List<Player> getPlayersToSave() {
		return getPlayers(false);
	}

	public List<Player> getPlayersToDelete() {
		return getPlayers(true);
	}

	private List<Player> getPlayers(boolean delete) {
		List<Player> players = new ArrayList<>();
		for (PlayerView playerView : playerViews) {
			if (playerView.isDelete() == delete) {
				players.add(playerView.getPlayer());
			}
		}
		return players;
	}

	public void setPlayers(List<Player> players) {
		if (players != null) {
			playerViews.clear();
			for (Player player : players) {
				playerViews.add(new PlayerView(player));
			}
			Collections.sort(playerViews);
		}
	}

	public void removePlayersToDelete() {
		for (PlayerView playerView : playerViews) {
			if (playerView.isDelete()) {
				playerViews.remove(playerView);
			}
		}
	}

	public List<PlayerView> getPlayerViews() {
		return playerViews;
	}

	public void setPlayerViews(List<PlayerView> playerViews) {
		this.playerViews = playerViews;
	}

	@Override
	public String toString() {
		return playerViews.toString();
	}

}