package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class Track_Playlist_id implements Serializable {
	@ManyToOne()
	@JoinColumn(name="track_id")
	private Track track;
	
	@ManyToOne()
	@JoinColumn(name="playlist_id")
	private Playlist playlist;

	public Track getTrack() {
		return track;
	}

	public void setTrack(Track track) {
		this.track = track;
	}

	public Playlist getPlaylist() {
		return playlist;
	}

	public void setPlaylist(Playlist playlist) {
		this.playlist = playlist;
	}
	
	
}
