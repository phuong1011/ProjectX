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
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 *
 * @author Leopold
 */
@Entity
@Table(name = "user_type")
@Data
public class UserType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "typeId")
    private Integer typeId;
    @Basic(optional = false)
    @Column(name = "typeName")
    private String typeName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "typeId")
    @JsonIgnore
    private List<User> userList;


}
