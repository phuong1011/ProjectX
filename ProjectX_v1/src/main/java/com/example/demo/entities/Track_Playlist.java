package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "track_playlist")
public class Track_Playlist implements Serializable {
	@EmbeddedId
	private Track_Playlist_id Id;
	
	@Column(name = "created_at")
	private String created_at;

	public Track_Playlist_id getId() {
		return Id;
	}

	public void setId(Track_Playlist_id id) {
		Id = id;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
}
