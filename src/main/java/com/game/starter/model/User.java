package com.game.starter.model;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Data
@Entity
@Table(name = "user_info")
public class User {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int userID;

	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonManagedReference
	private Collection<Score> scores = new HashSet();

	@Column(unique = true)
	private String userName;

	
	
	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Collection<Score> getScores() {
		return scores;
	}

	public void setScores(Collection<Score> scores) {
		this.scores = scores;
	}
	
	
}
