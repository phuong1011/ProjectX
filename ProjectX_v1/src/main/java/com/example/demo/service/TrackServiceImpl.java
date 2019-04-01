package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Track;
import com.example.demo.repository.TrackRepository;

@Service("trackService")
public class TrackServiceImpl implements TrackService{

	private TrackRepository trackRepository;

	@Autowired
	public void setTrackRepository(TrackRepository trackRepository) {
		this.trackRepository = trackRepository;
	}

	@Override
	public List<Track> getAll() {
		return trackRepository.findAll();
	}

	@Override
	public Track getOneById(Integer id) {
		Track track = trackRepository.findByTrackId(id);
		return track;
	}

	@Override
	public List<Track> FindByName(String name) {
		return trackRepository.findBytrackNameContaining(name);
	}
	
	
}
