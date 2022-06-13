package com.game.starter.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Game {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int gameID;

	@OneToMany(mappedBy = "game", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Score> scores;

	@Column(unique = true)
	private String gameName;

	public int getGameID() {
		return gameID;
	}

	public void setGameID(int gameID) {
		this.gameID = gameID;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

}
