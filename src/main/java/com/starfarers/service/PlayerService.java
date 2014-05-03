package com.starfarers.service;

import java.util.List;

import com.starfarers.domain.Player;

public interface PlayerService {

	List<Player> getPlayers();

	void savePlayers(List<Player> players);

	void removePlayers(List<Player> players);

}