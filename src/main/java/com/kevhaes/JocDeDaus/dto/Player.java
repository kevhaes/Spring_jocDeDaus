/**
 * @author KevHaes
 *
 */
package com.kevhaes.JocDeDaus.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author KevHaes
 *
 */
@Entity
public class Player {
	/////////////// ATRIBUTES ///////////////
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;

	@OneToMany
	@JoinColumn(name = "player_id")
	List<Game> games;

	/////////////// CONSTRUCTORS ///////////////
	public Player(Long id, String name, List<Game> games) {
		this.id = id;
		this.name = name;
		this.games = games;
	}

	public Player() {
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the games
	 */
	//

	@JsonIgnore
	@OneToMany(fetch = FetchType.EAGER)
	public List<Game> getGames() {
		return games;
	}

	/**
	 * @param games the games to set
	 */

	public void setGames(List<Game> games) {
		this.games = games;
	}

/////////////// TOSTRING ///////////////

	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + ", games=" + games + "]";
	}

}