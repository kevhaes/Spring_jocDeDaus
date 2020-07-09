/**
 * @author KevHaes
 *
 */
package com.kevhaes.JocDeDaus.service;

import java.util.List;

import com.kevhaes.JocDeDaus.dto.Player;

/**
 * @author KevHaes
 *
 */
public interface IPlayerService {

	Player createNewPlayer(Player player);

	List<Player> showAllPlayers();

	Player showOnePlayerById(Long id);

}
