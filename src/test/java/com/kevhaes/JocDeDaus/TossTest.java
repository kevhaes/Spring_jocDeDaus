/**
 * @author KevHaes
 *
 */
package com.kevhaes.JocDeDaus;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

import java.util.Calendar;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.kevhaes.JocDeDaus.dao.ITossDao;
import com.kevhaes.JocDeDaus.dto.Toss;

/**
 * @author KevHaes
 *
 */
@DataJpaTest
@TestMethodOrder(OrderAnnotation.class)
public class TossTest {
	/////////////// ATRIBUTES ///////////////
	@Autowired
	private ITossDao iTossDao;
	/////////////// CONSTRUCTORS ///////////////

	/////////////// GETTERS & SETTERS ///////////////

	/////////////// METHODS ///////////////

	@Test
	@Order(1)
	public void testCreateToss() {
		System.out.println("-----------start test 1 ----------------------");
		Toss toss = new Toss(100L, 5, 2, Calendar.getInstance().getTime());
		Toss savedToss = iTossDao.save(toss);
		System.out.println("SAVED TOSS:::::::::" + savedToss);
		assertNotNull(savedToss);
	}

	@Test
	@Order(2)
	public void findTossById() {
		System.out.println("-----------start test 2 ----------------------");
		Long id = 100L;
		Toss toss = iTossDao.findById(id).get();
		System.out.println("Found TOSS:::::::::" + toss);
		assertThat(toss.getId().equals(id));
		// assertNotNull(toss);

	}
	/////////////// TOSTRING ///////////////

}
