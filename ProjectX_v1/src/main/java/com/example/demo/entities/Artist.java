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
import lombok.Data;

/**
 *
 * @author Leopold
 */
@Entity
@Table(name = "artist")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
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


}
