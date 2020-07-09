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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

	@GetMapping
	public List<Player> showAllPlayers() {
		return playerService.showAllPlayers();
	}

	@GetMapping(path = "/{id}")
	public Player showOnePlayerById(@PathVariable Long id) {
		return playerService.showOnePlayerById(id);
	}

	@PostMapping
	public Player createNewPlayer(@RequestBody Player player) {
		return playerService.createNewPlayer(player);
	}

}
