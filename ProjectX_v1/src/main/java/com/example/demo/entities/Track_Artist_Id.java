package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class Track_Artist_Id implements Serializable {
	@ManyToOne()
	@JoinColumn(name="track_id")
	private Track track;
	
	@ManyToOne()
	@JoinColumn(name="artist_id")
	private Artist artist;

	public Track getTrack() {
		return track;
	}

	public void setTrack(Track track) {
		this.track = track;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}
	
	
}
