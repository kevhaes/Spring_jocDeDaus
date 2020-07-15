/**
 * @author KevHaes
 *
 */
package com.kevhaes.JocDeDaus.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

/**
 * @author KevHaes
 *
 */
@Entity
public class Toss {
	/////////////// ATRIBUTES ///////////////
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int dice1;
	private int dice2;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date registration;

	@OneToMany
	@JoinColumn(name = "id")
	List<Game> games;

	/////////////// CONSTRUCTORS ///////////////

	public Toss(Long id, int dice1, int dice2, Date registration) {
		this.id = id;
		this.dice1 = dice1;
		this.dice2 = dice2;
		this.registration = registration;
	}

	public Toss() {
	}

	/////////////// METHODS ///////////////

	public int throwOneDice() {
		return (int) (Math.random() * 6) + 1;
	}

	/////////////// GETTERS & SETTERS ///////////////
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the dice1
	 */
	public int getDice1() {
		return dice1;
	}

	/**
	 * @param dice1 the dice1 to set
	 */
	public void setDice1(int dice1) {
		this.dice1 = dice1;
	}

	/**
	 * @return the dice2
	 */
	public int getDice2() {
		return dice2;
	}

	/**
	 * @param dice2 the dice2 to set
	 */
	public void setDice2(int dice2) {
		this.dice2 = dice2;
	}

	/**
	 * @return the registration
	 */
	public Date getRegistration() {
		return registration;
	}

	/**
	 * @param registration the registration to set
	 */
	public void setRegistration(Date registration) {
		this.registration = registration;
	}

	/////////////// TOSTRING ///////////////
	@Override
	public String toString() {
		return "Toss [id=" + id + ", dice1=" + dice1 + ", dice2=" + dice2 + ", registration=" + registration + "]";
	}

}
