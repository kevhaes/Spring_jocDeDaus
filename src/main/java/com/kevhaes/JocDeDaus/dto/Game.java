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
	private int winrate;
	private Date timestamp;

	@ManyToOne
	@JoinColumn(name = "player_id")
	private Player player;

	@ManyToOne
	@JoinColumn(name = "toss_id")
	private Toss toss;

/////////////// CONSTRUCTORS ///////////////
	public Game(Long id, int winrate, Date timestamp, Player player, Toss toss) {
		this.id = id;
		this.winrate = winrate;
		this.timestamp = timestamp;
		this.player = player;
		this.toss = toss;
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
	 * @return the winrate
	 */
	public int getWinrate() {
		return winrate;
	}

	/**
	 * @param winrate the winrate to set
	 */
	public void setWinrate(int winrate) {
		this.winrate = winrate;
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
	 * @return the player
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * @param player the player to set
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}

	/**
	 * @return the toss
	 */
	public Toss getToss() {
		return toss;
	}

	/**
	 * @param toss the toss to set
	 */
	public void setToss(Toss toss) {
		this.toss = toss;
	}

	/////////////// TOSTRING ///////////////
	@Override
	public String toString() {
		return "Game [id=" + id + ", winrate=" + winrate + ", timestamp=" + timestamp + ", player=" + player + ", toss="
				+ toss + "]";
	}

}
