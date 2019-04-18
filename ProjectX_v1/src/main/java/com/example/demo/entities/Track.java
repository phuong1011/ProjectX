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
import lombok.Data;

/**
 *
 * @author Leopold
 */
@Entity
@Table(name = "track")
@Data
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
    @Lob
    @Column(name = "audioPath")
    private String audioPath;
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
    @JoinTable(name = "track_artist", joinColumns = @JoinColumn(name = "track_id", nullable = false, updatable = false, insertable = false), inverseJoinColumns = @JoinColumn(name = "artist_id"))
    private List<Artist> artists;

}
