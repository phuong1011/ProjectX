package com.example.demo.service;

import java.util.List;
import java.util.Map;

import com.example.demo.entities.Playlist;

public interface PlaylistService {
	Playlist findById(Integer id);
	public List<Playlist> getAll();
	public List<Playlist> getAllPlaylistByUserId(String userId);
	public List<Playlist> getAllPlaylistByCategoryId(int cateId,int page, int size);
	public List<Playlist> getAllFollowPlaylistByUserId(String userId);
	public List<Playlist> getAllPlaylistByType(int type,int page, int size);
	public List<Map<String, Object>> getPlaylistCount(int page, int size);
}
