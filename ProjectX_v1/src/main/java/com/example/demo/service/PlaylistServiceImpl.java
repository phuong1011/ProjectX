package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Playlist;
import com.example.demo.repository.PlaylistRepository;

@Service("playlistService")
public class PlaylistServiceImpl implements PlaylistService{
	
	private PlaylistRepository playlistRepository;
	
	@Autowired
	public void setPlaylistRepository(PlaylistRepository playlistRepository) {
		this.playlistRepository = playlistRepository;
	}

	@Override
	public List<Playlist> getAll() {
		return playlistRepository.findAll();
	}

	@Override
	public List<Playlist> getAllPlaylistByUserId(int id) {
		return playlistRepository.findAllByUserId(id);
	}

}
