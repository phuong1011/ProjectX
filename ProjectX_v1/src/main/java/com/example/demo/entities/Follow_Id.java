package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

@Embeddable
public class Follow_Id implements Serializable {
	@ManyToOne()
	@JoinColumn(name="user_id",columnDefinition="varchar(50)")
	@Size(max = 50)
	private User user;
	
	@ManyToOne()
	@JoinColumn(name="artist_id")
	private Artist artist;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}
	
	
}
