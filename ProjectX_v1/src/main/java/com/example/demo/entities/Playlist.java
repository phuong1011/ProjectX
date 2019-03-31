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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author Leopold
 */
@Entity
@Table(name = "playlist")
public class Playlist implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "playlistId")
    private Integer playlistId;
    @Basic(optional = false)
    @Column(name = "playlistName")
    private String playlistName;
    @Basic(optional = false)
    @Lob
    @Column(name = "imagePath")
    private String imagePath;
    @Basic(optional = false)
    @Column(name = "userId")
    private String userId;
    @Column(name = "type")
    private int type;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="category_id")
    private Category category;

    public Playlist() {
    }

    public Playlist(Integer playlistId) {
        this.playlistId = playlistId;
    }

    public Playlist(Integer playlistId, String playlistName, String imagePath, String userId) {
        this.playlistId = playlistId;
        this.playlistName = playlistName;
        this.imagePath = imagePath;
        this.userId = userId;
    }

    public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Integer getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(Integer playlistId) {
        this.playlistId = playlistId;
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    

    public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (playlistId != null ? playlistId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Playlist)) {
            return false;
        }
        Playlist other = (Playlist) object;
        if ((this.playlistId == null && other.playlistId != null) || (this.playlistId != null && !this.playlistId.equals(other.playlistId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cc2.Playlist[ playlistId=" + playlistId + " ]";
    }
    
}
