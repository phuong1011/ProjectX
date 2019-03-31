package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Album;
import com.example.demo.repository.AlbumRepository;

@Service("albumService")
public class AlbumServiceImpl implements AlbumService {

	private AlbumRepository albumRepository;

	@Autowired
	public void setAlbumRepository(AlbumRepository albumRepository) {
		this.albumRepository = albumRepository;
	}

	@Override
	public List<Album> getAll() {
		return albumRepository.findAll();
	}

	@Override
	public List<Album> getAllOrderByReleaseDate() {
		return albumRepository.findAllByOrderByReleaseDateDesc();
	}
	
}
