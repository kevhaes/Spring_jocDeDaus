/**
 * @author KevHaes
 *
 */
package com.kevhaes.JocDeDaus.service;

import java.util.List;

import com.kevhaes.JocDeDaus.dto.Game;
import com.kevhaes.JocDeDaus.dto.Player;

/**
 * @author KevHaes
 *
 */
public interface IPlayerService {

	Player createNewPlayer(Player player);

	Player modifyPlayer(Long id, Player player);

	List<Player> showAllPlayers();

	List<Player> showAllPlayersRanked();

	Player showPlayerWithLowestTotalScore();

	Player showPlayerWithHighestTotalScore();

	Player showOnePlayerById(Long id);

	List<Game> showOnePlayerByIdGames(Long id);

	List<Game> showOnePlayerByIdGamesWon(Long id);
}
