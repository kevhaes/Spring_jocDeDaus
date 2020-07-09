/**
 * @author KevHaes
 *
 */
package com.kevhaes.JocDeDaus.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kevhaes.JocDeDaus.dto.Player;

/**
 * @author KevHaes
 *
 */
public interface IPlayerDao extends JpaRepository<Player, Long> {

}
