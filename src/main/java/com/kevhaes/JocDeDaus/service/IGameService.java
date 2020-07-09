/**
 * @author KevHaes
 *
 */
package com.kevhaes.JocDeDaus.service;

import java.util.List;

import com.kevhaes.JocDeDaus.dto.Game;

/**
 * @author KevHaes
 *
 */
public interface IGameService {

	public Game createGame(Game game);

	public List<Game> ShowAllGamesOfOnePlayerById(Long playerId);

}
