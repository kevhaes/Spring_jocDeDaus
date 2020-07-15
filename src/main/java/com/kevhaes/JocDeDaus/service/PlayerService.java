/**
 * @author KevHaes
 *
 */
package com.kevhaes.JocDeDaus.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kevhaes.JocDeDaus.dao.IGameDao;
import com.kevhaes.JocDeDaus.dao.IPlayerDao;
import com.kevhaes.JocDeDaus.dao.ITossDao;
import com.kevhaes.JocDeDaus.dto.Game;
import com.kevhaes.JocDeDaus.dto.Player;

/**
 * @author KevHaes
 *
 */
@Service
public class PlayerService implements IPlayerService {

	/////////////// ATRIBUTES ///////////////
	@Autowired
	IPlayerDao iPlayerDao;

	@Autowired
	IGameDao iGameDao;

	@Autowired
	ITossDao iTossDao;

	/////////////// METHODS ///////////////
	@Override
	public Player createNewPlayer(Player player) {
		try {
			if (player.getName().equals("")) {
				player.setName("anonime");
			}
		} catch (Exception e) {
			System.out.println("name assigned due to exeption: " + e.getMessage());
			player.setName("anonime");
		}

		return iPlayerDao.save(player);
	}

	@Override
	public Player modifyPlayer(Long id, Player player) {
		Player modifiedPlayer = iPlayerDao.getOne(id);
		modifiedPlayer.setName(player.getName());
		return iPlayerDao.save(modifiedPlayer);
	}

	@Override
	public List<Player> showAllPlayers() {
		return iPlayerDao.findAll();
	}

	@Override
	public List<Player> showAllPlayersRanked() {
		List<Player> ranking = new ArrayList<Player>(iPlayerDao.findAll());
		Collections.sort(ranking, Comparator.comparing(Player::getTotalpoints).reversed());
		return ranking;
	}

	@Override
	public Player showPlayerWithLowestTotalScore() {
		List<Player> ranking = new ArrayList<Player>(iPlayerDao.findAll());
		Collections.sort(ranking, Comparator.comparing(Player::getTotalpoints).reversed());
		return ranking.get(0);
	}

	@Override
	public Player showPlayerWithHighestTotalScore() {
		List<Player> ranking = new ArrayList<Player>(iPlayerDao.findAll());
		Collections.sort(ranking, Comparator.comparing(Player::getTotalpoints).reversed());
		return ranking.get(ranking.size() - 1);
	}

	@Override
	public Player showOnePlayerById(Long id) {

		return iPlayerDao.findById(id).get();
	}

	@Override
	public List<Game> showOnePlayerByIdGames(Long id) {
		List<Game> result = new ArrayList<Game>();
		List<Game> allGames = iGameDao.findAll();
		for (Game game : allGames) {
			if (game.getPlayer1().getId().equals(id)) {
				result.add(game);
			} else if (game.getPlayer2().getId().equals(id)) {
				result.add(game);
			}
		}
		return result;
	}

	@Override
	public List<Game> showOnePlayerByIdGamesWon(Long id) {
		System.out.println("---------start won ranking -----------");
		List<Game> result = new ArrayList<Game>();
		List<Game> allGames = iGameDao.findAll();

		try {
			for (Game game : allGames) {
				if (game.getPlayer1().getId().equals(id)) {

					if (game.getWinner().getId().equals(id)) {
						result.add(game);
					}
				} else if (game.getPlayer2().getId().equals(id)) {
					if (game.getWinner().getId().equals(id)) {
						result.add(game);
					}
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return result;
	}

}