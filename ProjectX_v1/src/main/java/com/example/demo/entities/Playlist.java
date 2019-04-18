/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.entities;

import lombok.Data;

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

/**
 *
 * @author Leopold
 */
@Entity
@Table(name = "playlist")
@Data
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

    @ManyToMany
    @JoinTable(name="track_playlist", joinColumns= @JoinColumn(name = "playlist_id"), inverseJoinColumns=@JoinColumn(name = "track_id"))
    private List<Track> tracks;
    

}
