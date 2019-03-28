package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Playlist;

public interface PlaylistService {
	public List<Playlist> getAll();
	public List<Playlist> getAllPlaylistByUserId(int userId);
}
