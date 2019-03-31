package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "follow")
public class Follow {
	
	@EmbeddedId
	private Follow_Id Id;
	
	@Column(name = "created_at")
	private String created_at;

	public Follow_Id getId() {
		return Id;
	}

	public void setId(Follow_Id id) {
		Id = id;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	
}
