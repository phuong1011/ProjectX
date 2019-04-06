package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Artist;
import com.example.demo.repository.ArtistRepository;

@Service("artistService")
public class ArtistServiceImpl implements ArtistService {

	private ArtistRepository artistRepository;

	@Autowired
	public void setArtistRepository(ArtistRepository artistRepository) {
		this.artistRepository = artistRepository;
	}

	@Override
	public List<Artist> FindByName(String name) {
		return artistRepository.findByartistNameContaining(name);
	}

	@Override
	public Artist findById(int id) {
		return artistRepository.getOne(id);
	}

}
