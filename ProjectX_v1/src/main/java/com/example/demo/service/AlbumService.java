package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Album;

public interface AlbumService {
	List<Album> getAll();
	List<Album> getAllOrderByReleaseDate();
	List<Album> getAllAlbumByCategoryId(int cateId);
	List<Album> getAllFollowAlbumByUserId(String userId);
	Album getAlbumById(int id);
}
