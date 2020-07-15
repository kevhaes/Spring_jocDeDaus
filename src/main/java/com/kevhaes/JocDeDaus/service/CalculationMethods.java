/**
 * @author KevHaes
 *
 */
package com.kevhaes.JocDeDaus.service;

import com.kevhaes.JocDeDaus.dto.Game;
import com.kevhaes.JocDeDaus.dto.Player;

/**
 * @author KevHaes
 *
 */
public class CalculationMethods {

	// find the winner of the game
	static Player andTheWinnerIs(Game game) {
		Player winnerIs = null;
		int resultPlayer1 = (game.getToss1().getDice1()) + (game.getToss1().getDice2());
		int resultPlayer2 = (game.getToss2().getDice1()) + (game.getToss2().getDice2());

		if (resultPlayer1 != resultPlayer2) {
			if (resultPlayer1 == 7) {
				winnerIs = game.getPlayer1();
			} else if (resultPlayer2 == 7) {
				winnerIs = game.getPlayer2();
			}
		}
		System.out.println("CalculationMethods winnerIs ---->" + winnerIs);
		return winnerIs;
	}

	// find the loser of the game
	static Player andTheLoserIs(Game game) {
		Player winner = andTheWinnerIs(game);
		Player loser = null;
		if (winner != null) {
			if (game.getPlayer1().equals(winner)) {
				loser = game.getPlayer2();
			} else if (game.getPlayer2().equals(winner)) {
				loser = game.getPlayer1();
			}
		}
		System.out.println("CalculationMethods andTheLoserIs ---->" + loser);
		return loser;
	}

}
