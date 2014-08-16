package com.starfarers.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.starfarers.dao.PlayerDao;
import com.starfarers.domain.Player;

@Service
public class PlayerService {

	@Autowired
	private transient PlayerDao playerDao;

	public List<Player> getPlayers() {
		return playerDao.findAll();
	}

	public List<Player> getActivePlayers() {
		return playerDao.getPlayersByActive(true);
	}

	public List<Player> getInactivePlayers() {
		return playerDao.getPlayersByActive(false);
	}

	public void save(List<Player> players) {
		playerDao.save(players);
	}

	@Transactional
	public void remove(List<Player> players) {
		for (Player player : players) {
			playerDao.remove(player);
		}
	}

}