/**
 * @author KevHaes
 *
 */
package com.kevhaes.JocDeDaus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kevhaes.JocDeDaus.dao.IPlayerDao;
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

	/////////////// METHODS ///////////////
	@Override
	public Player createNewPlayer(Player player) {
		return iPlayerDao.save(player);
	}

	@Override
	public List<Player> showAllPlayers() {
		return iPlayerDao.findAll();
	}

	@Override
	public Player showOnePlayerById(Long id) {

		return iPlayerDao.findById(id).get();
	}

}
