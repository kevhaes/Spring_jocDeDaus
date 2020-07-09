/**
 * @author KevHaes
 *
 */
package com.kevhaes.JocDeDaus.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kevhaes.JocDeDaus.dto.Toss;

/**
 * @author KevHaes
 *
 */
public interface ITossDao extends JpaRepository<Toss, Long> {

}
