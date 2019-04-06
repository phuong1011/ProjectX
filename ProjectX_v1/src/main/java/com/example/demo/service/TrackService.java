package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Track;

public interface TrackService {
	List<Track> getAll();

	Track getOneById(Integer id);

	List<Track> FindByName(String name);
}
