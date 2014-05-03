package com.starfarers.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.starfarers.dao.PlayerDao;
import com.starfarers.domain.Player;
import com.starfarers.service.PlayerService;

@Service
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	private transient PlayerDao playerDao;

	public List<Player> getPlayers() {
		return playerDao.findAll();
	}

	public void savePlayers(List<Player> players) {
		playerDao.saveAll(players);
	}

	@Transactional
	public void removePlayers(List<Player> players) {
		for (Player player : players) {
			playerDao.remove(player);
		}
	}

}