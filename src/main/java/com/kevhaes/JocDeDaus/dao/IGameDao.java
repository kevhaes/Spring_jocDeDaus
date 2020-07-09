/**
 * @author KevHaes
 *
 */
package com.kevhaes.JocDeDaus.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kevhaes.JocDeDaus.dto.Game;

/**
 * @author KevHaes
 *
 */
public interface IGameDao extends JpaRepository<Game, Long> {

}
