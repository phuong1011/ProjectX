/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author Leopold
 */
@Entity
@Table(name = "track")
public class Track implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "trackId")
    private Integer trackId;
    @Basic(optional = false)
    @Column(name = "trackName")
    private String trackName;
    @Basic(optional = false)
    @Column(name = "duration")
    private long duration;
    @Basic(optional = false)
    @Lob
    @Column(name = "audioPath")
    private String audioPath;
    @Basic(optional = false)
    @Column(name = "size")
    private int size;
    @Basic(optional = false)
    @Lob
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "userUploadId")
    private String userUploadId;
    
    @JoinColumn(name = "albumId", referencedColumnName = "albumId")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Album album;

    @ManyToMany
    @JoinTable(name="track_artist", joinColumns= @JoinColumn(name = "track_id",nullable = false, updatable = false,insertable = false), inverseJoinColumns=@JoinColumn(name = "artist_id"))
    private List<Artist> artists;
    
    public Track() {
    }

    public Track(Integer trackId) {
        this.trackId = trackId;
    }

    public Track(Integer trackId, String trackName, long duration, String audioPath, int size, String description, String userUploadId) {
        this.trackId = trackId;
        this.trackName = trackName;
        this.duration = duration;
        this.audioPath = audioPath;
        this.size = size;
        this.description = description;
        this.userUploadId = userUploadId;
    }

    public Integer getTrackId() {
        return trackId;
    }

    public void setTrackId(Integer trackId) {
        this.trackId = trackId;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public String getAudioPath() {
        return audioPath;
    }

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public void setAudioPath(String audioPath) {
        this.audioPath = audioPath;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUserUploadId() {
        return userUploadId;
    }

    public void setUserUploadId(String userUploadId) {
        this.userUploadId = userUploadId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (trackId != null ? trackId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Track)) {
            return false;
        }
        Track other = (Track) object;
        if ((this.trackId == null && other.trackId != null) || (this.trackId != null && !this.trackId.equals(other.trackId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cc2.Track[ trackId=" + trackId + " ]";
    }
    
    public List<Artist> getArtists() {
		return artists;
	}

	public void setArtists(List<Artist> artists) {
		this.artists = artists;
	}
}
