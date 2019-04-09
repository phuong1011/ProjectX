package com.example.demo.service;

import java.util.List;
import java.util.Map;

import com.example.demo.entities.Playlist;

public interface PlaylistService {
	Playlist findById(Integer id);
	List<Playlist> getAll();
	List<Playlist> getAllPlaylistByUserId(String userId);
	List<Playlist> getAllPlaylistByCategoryId(int cateId,int page, int size);
	List<Playlist> getAllFollowPlaylistByUserId(String userId);
	List<Playlist> getAllPlaylistByType(int type,int page, int size);
	List<Map<String, Object>> getPlaylistCount(int page, int size);
	void addNew(Playlist playList);
	Playlist update(Playlist playList);
	void delete(Integer id);
}
