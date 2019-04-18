package com.example.demo.entities;

import lombok.Data;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

@Embeddable
@Data
public class Follow_Id implements Serializable {
	@ManyToOne()
	@JoinColumn(name="user_id",columnDefinition="varchar(50)")
	@Size(max = 50)
	private User user;
	
	@ManyToOne()
	@JoinColumn(name="artist_id")
	private Artist artist;
	
	
}
