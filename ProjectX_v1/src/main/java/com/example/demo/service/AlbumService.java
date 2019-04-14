package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.AlbumDto;
import com.example.demo.entities.Album;

public interface AlbumService {
	List<AlbumDto> getAll();
	List<AlbumDto> getAllByUserId(int artistId);
	List<AlbumDto> getAllOrderByReleaseDate();
	List<AlbumDto> getAllAlbumByCategoryId(int cateId);
	List<AlbumDto> getAllFollowAlbumByUserId(String userId);
	AlbumDto getAlbumById(int id);
	AlbumDto saveAlbum(AlbumDto album);
}
