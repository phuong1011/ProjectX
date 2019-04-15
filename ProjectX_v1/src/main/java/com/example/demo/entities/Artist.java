/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.entities;
import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author Leopold
 */
@Entity
@Table(name = "artist")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Artist implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "artist_id")
    private Integer artistId;
    @Basic(optional = false)
    @Lob
    @Column(name = "artist_name")
    private String artistName;
    @Basic(optional = false)
    @Lob
    @Column(name = "bio")
    private String bio;
    @Basic(optional = false)
    @Lob
    @Column(name = "custom_url")
    private String customUrl;
    @Basic(optional = false)
    @Lob
    @Column(name = "background_path")
    private String backgroundPath;
    @JoinColumn(name = "userId",columnDefinition="varchar(50)")
    @OneToOne(optional = false, fetch = FetchType.EAGER)
    //@JsonIgnore
    private User userId;

    public Artist() {
    }

    public Artist(Integer artistId) {
        this.artistId = artistId;
    }

    public Artist(Integer artistId, String artistName, String bio, String customUrl, String backgroundPath) {
        this.artistId = artistId;
        this.artistName = artistName;
        this.bio = bio;
        this.customUrl = customUrl;
        this.backgroundPath = backgroundPath;
    }

    public Integer getArtistId() {
        return artistId;
    }

    public void setArtistId(Integer artistId) {
        this.artistId = artistId;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getCustomUrl() {
        return customUrl;
    }

    public void setCustomUrl(String customUrl) {
        this.customUrl = customUrl;
    }

    public String getBackgroundPath() {
        return backgroundPath;
    }

    public void setBackgroundPath(String backgroundPath) {
        this.backgroundPath = backgroundPath;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (artistId != null ? artistId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Artist)) {
            return false;
        }
        Artist other = (Artist) object;
        if ((this.artistId == null && other.artistId != null) || (this.artistId != null && !this.artistId.equals(other.artistId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cc2.Artist[ artistId=" + artistId + " ]";
    }
    
}
