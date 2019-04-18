package com.example.demo.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "follow")
@Data
public class Follow {
	
	@EmbeddedId
	private Follow_Id Id;
	
	@Column(name = "created_at")
	private String created_at;
	
}
