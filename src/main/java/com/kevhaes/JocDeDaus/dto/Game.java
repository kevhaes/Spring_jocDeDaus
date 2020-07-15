/**
 * @author KevHaes
 *
 */
package com.kevhaes.JocDeDaus.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author KevHaes
 *
 */
@Entity

public class Game {

	/////////////// ATRIBUTES ///////////////
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date timestamp;

	@ManyToOne
	@JoinColumn(name = "player1_id")
	private Player player1;

	@ManyToOne
	@JoinColumn(name = "player2_id")
	private Player player2;

	@ManyToOne
	@JoinColumn(name = "toss1_id")
	private Toss toss1;

	@ManyToOne
	@JoinColumn(name = "toss2_id")
	private Toss toss2;

	@ManyToOne
	@JoinColumn(name = "winner_id")
	private Player winner;

/////////////// CONSTRUCTORS ///////////////
	public Game(Long id, Date timestamp, Player player1, Toss toss1, Player player2, Toss toss2, Player winner) {
		this.id = id;
		this.timestamp = timestamp;
		this.player1 = player1;
		this.player2 = player2;
		this.toss1 = toss1;
		this.toss2 = toss2;
		this.winner = winner;

	}

	public Game() {
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
	 * @return the timestamp
	 */
	public Date getTimestamp() {
		return timestamp;
	}

	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * @return the player1
	 */
	// @JsonIgnore
	public Player getPlayer1() {
		return player1;
	}

	/**
	 * @param player1 the player1 to set
	 */
	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}

	/**
	 * @return the player2
	 */
	// @JsonIgnore
	public Player getPlayer2() {
		return player2;
	}

	/**
	 * @param player2 the player2 to set
	 */
	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}

	/**
	 * @return the toss1
	 */
	// @JsonIgnore
	public Toss getToss1() {
		return toss1;
	}

	/**
	 * @param toss1 the toss1 to set
	 */
	public void setToss1(Toss toss1) {
		this.toss1 = toss1;
	}

	/**
	 * @return the toss2
	 */
	// @JsonIgnore
	public Toss getToss2() {
		return toss2;
	}

	/**
	 * @param toss2 the toss2 to set
	 */
	public void setToss2(Toss toss2) {
		this.toss2 = toss2;
	}

	/**
	 * @return the winner
	 */
	// @JsonIgnore
	public Player getWinner() {
		return winner;
	}

	/**
	 * @param winner the winner to set
	 */

	public void setWinner(Player winner) {
		this.winner = winner;
	}

	/////////////// TOSTRING ///////////////
	@Override
	public String toString() {
		return "Game [id=" + id + ", timestamp=" + timestamp + ", player1=" + player1 + ", player2=" + player2
				+ ", toss1=" + toss1 + ", toss2=" + toss2 + ", winner=" + winner + "]";
	}

}
