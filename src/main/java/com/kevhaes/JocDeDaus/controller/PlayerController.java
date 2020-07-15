/**
 * @author KevHaes
 *
 */
package com.kevhaes.JocDeDaus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kevhaes.JocDeDaus.dto.Game;
import com.kevhaes.JocDeDaus.dto.Player;
import com.kevhaes.JocDeDaus.service.PlayerService;

/**
 * @author KevHaes
 *
 */
@RestController
@RequestMapping(path = "/api/players")
public class PlayerController {
	/////////////// ATRIBUTES ///////////////
	@Autowired
	PlayerService playerService;

	/////////////// METHODS ///////////////

	@PostMapping
	public Player createNewPlayer(@RequestBody Player player) {
		return playerService.createNewPlayer(player);
	}

	@PutMapping(path = "/{id}")
	public Player modifyPlayer(@PathVariable Long id, @RequestBody Player player) {
		return playerService.modifyPlayer(id, player);
	}

	@GetMapping
	public List<Player> showAllPlayers() {
		return playerService.showAllPlayers();
	}

	@GetMapping(path = "/ranking")
	public List<Player> showAllPlayersRanked() {
		return playerService.showAllPlayersRanked();
	}

	@GetMapping(path = "/loser")
	public Player showPlayerWithHighestTotalScore() {
		return playerService.showPlayerWithHighestTotalScore();
	}

	@GetMapping(path = "/winner")
	public Player showPlayerWithLowestTotalScore() {
		return playerService.showPlayerWithLowestTotalScore();
	}

	@GetMapping(path = "/{id}")
	public Player showOnePlayerById(@PathVariable Long id) {
		return playerService.showOnePlayerById(id);
	}

	@GetMapping(path = "/{id}/games")
	public List<Game> showOnePlayerByIdGames(@PathVariable Long id) {
		return playerService.showOnePlayerByIdGames(id);
	}

	@GetMapping(path = "/{id}/games/won")
	public List<Game> showOnePlayerByIdGamesWon(@PathVariable Long id) {
		return playerService.showOnePlayerByIdGamesWon(id);
	}
}
