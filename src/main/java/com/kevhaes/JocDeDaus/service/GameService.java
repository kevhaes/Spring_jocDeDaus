/**
 * @author KevHaes
 *
 */
package com.kevhaes.JocDeDaus.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kevhaes.JocDeDaus.dao.IGameDao;
import com.kevhaes.JocDeDaus.dao.IPlayerDao;
import com.kevhaes.JocDeDaus.dto.Game;
import com.kevhaes.JocDeDaus.dto.Player;

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

	/////////////// METHODS ///////////////
	@Override
	public Game createGame(Game game) {
		game.setTimestamp(new Date());
		Player winner = CalculationMethods.andTheWinnerIs(game);
		Player loser = CalculationMethods.andTheLoserIs(game);
		game.setWinner(winner);
		try {
			iPlayerDao.getOne(winner.getId()).setWinrate(updatedWinrateWinner(winner));
		} catch (Exception e) {
			System.out.println("NO WINNER");
		}
		try {
			iPlayerDao.getOne(loser.getId()).setWinrate(updatedWinrateLoser(loser));
		} catch (Exception e) {
			System.out.println("NO LOSER");
		}

		return iGameDao.save(game);
	}

	// amount games for player (incl actual game)
	public int participatedGames(Player player) {
		int participatedGames = 1;
		for (Game game : showAllGames()) {
			if (game.getPlayer1().equals(player)) {
				participatedGames++;
			} else if (game.getPlayer2().equals(player)) {
				participatedGames++;
			}
		}
		return participatedGames;

	}
//winner part

	// amount won games for winner (incl actual game)
	public int amountWonGamesWinner(Player player) {
		int amountWonGames = 1;
		for (Game game : showAllGames()) {
			if (game.getWinner() != null && game.getWinner().equals(player)) {
				amountWonGames++;
			}
		}

		return amountWonGames;
	}

	// winrate update winner
	public double updatedWinrateWinner(Player player) {
		double newWinrate = amountWonGamesWinner(player) / participatedGames(player);
		return newWinrate;
	}

//loser part

	// amount won games for loser (incl actual game)
	public int amountWonGamesLoser(Player player) {
		int amountWonGames = 0;
		for (Game game : showAllGames()) {
			if (game.getWinner() != null && game.getWinner().equals(player)) {
				amountWonGames++;
			}
		}

		return amountWonGames;
	}

	// winrate update loser
	public double updatedWinrateLoser(Player player) {
		double newWinrate = amountWonGamesLoser(player) / participatedGames(player);
		return newWinrate;
	}

	@Override
	public List<Game> showAllGames() {
		return iGameDao.findAll();
	}

}
