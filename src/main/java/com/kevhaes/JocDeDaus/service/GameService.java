/**
 * @author KevHaes
 *
 */
package com.kevhaes.JocDeDaus.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kevhaes.JocDeDaus.dao.IGameDao;
import com.kevhaes.JocDeDaus.dao.IPlayerDao;
import com.kevhaes.JocDeDaus.dao.ITossDao;
import com.kevhaes.JocDeDaus.dto.Game;

/**
 * @author KevHaes
 *
 */
@Service
public class GameService implements IGameService {
	/////////////// ATRIBUTES ///////////////
	@Autowired
	IGameDao iGameDao;
	@Autowired
	IPlayerDao iPlayerDao;
	@Autowired
	ITossDao iTossDao;

	/////////////// METHODS ///////////////
//	@Override
//	public Game createGame(Long playerId, Game game, Toss toss) {
//		game.setPlayer(iPlayerDao.getOne(playerId));
//		game.setToss(toss);
//		return iGameDao.save(game);
//	}

	@Override
	public List<Game> ShowAllGamesOfOnePlayerById(Long playerId) {
		List<Game> result = new ArrayList<Game>();
		for (Game game : iGameDao.findAll()) {
			if (game.getPlayer().getId().equals(playerId)) {
				result.add(game);
			}
		}
		return result;

	}

	@Override
	public Game createGame(Game game) {
		return iGameDao.save(game);
	}

}
