package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Album;
import com.example.demo.entities.Follow;
import com.example.demo.repository.AlbumRepository;
import com.example.demo.repository.FollowRepository;

@Service("albumService")
public class AlbumServiceImpl implements AlbumService {

	private AlbumRepository albumRepository;
	
	private FollowRepository followRepository;

	public FollowRepository getFollowRepository() {
		return followRepository;
	}

	@Autowired
	public void setFollowRepository(FollowRepository followRepository) {
		this.followRepository = followRepository;
	}

	public AlbumRepository getAlbumRepository() {
		return albumRepository;
	}

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

	@Override
	public List<Album> getAllFollowAlbumByUserId(String userId) {
		List<Follow> follows = followRepository.findByUserId(userId);
		List<Album> albums = new ArrayList<Album>();
		for (Follow follow : follows) {
			System.out.println(follow.getId().getArtist().getArtistId());
			albums.addAll(albumRepository.findByArtistId(follow.getId().getArtist().getArtistId()));
		}
		return albums;
	}

	@Override
	public List<Album> getAllAlbumByCategoryId(int cateId) {
		return albumRepository.findByCategoryId(cateId);
	}

	@Override
	public Album getAlbumById(int id) {
		return albumRepository.getOne(id);
	}

	@Override
	public List<Album> getAllByUserId(int artistId) {
		return albumRepository.findByArtistId(artistId);
	}

	
	
}
