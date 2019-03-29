package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Track;

public interface TrackService {
	public List<Track> getAll();
	public Track getOneById(Integer id);
}
