package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Artist;

public interface ArtistService {
	List<Artist> FindByName(String name);
	Artist FindByUserId(String userId);
	Artist findById(int id);
	Artist save(Artist artist);
}
