/**
 * @author KevHaes
 *
 */
package com.kevhaes.JocDeDaus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kevhaes.JocDeDaus.dao.ITossDao;
import com.kevhaes.JocDeDaus.dto.Toss;

/**
 * @author KevHaes
 *
 */
@Service
public class TossService implements ITossService {

	/////////////// ATRIBUTES ///////////////
	@Autowired
	ITossDao iTossDao;

	@Override
	public Toss createToss(Toss toss) {
		toss.setDice1(toss.throwOneDice());
		toss.setDice2(toss.throwOneDice());
		return iTossDao.save(toss);
	}

}
