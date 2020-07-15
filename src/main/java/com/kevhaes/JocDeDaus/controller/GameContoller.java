/**
 * @author KevHaes
 *
 */
package com.kevhaes.JocDeDaus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kevhaes.JocDeDaus.dto.Game;
import com.kevhaes.JocDeDaus.service.GameService;

/**
 * @author KevHaes
 *
 */
@RestController
@RequestMapping(path = "/api/games")
public class GameContoller {
	/////////////// ATRIBUTES ///////////////
	@Autowired
	GameService gameService;

	/////////////// CONSTRUCTORS ///////////////
	@GetMapping
	public List<Game> showAllGames() {
		return gameService.showAllGames();
	}

	@PostMapping
	public Game createGame(@RequestBody Game game) {
		return gameService.createGame(game);
	}

}
