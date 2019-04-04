package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Follow;
import com.example.demo.entities.Playlist;
import com.example.demo.repository.FollowRepository;
import com.example.demo.repository.PlaylistRepository;

@Service("playlistService")
public class PlaylistServiceImpl implements PlaylistService{
	
	private PlaylistRepository playlistRepository;
	
	private FollowRepository followRepository;
	
	@Autowired
	public void setFollowRepository(FollowRepository followRepository) {
		this.followRepository = followRepository;
	}
	
	@Autowired
	public void setPlaylistRepository(PlaylistRepository playlistRepository) {
		this.playlistRepository = playlistRepository;
	}

	@Override
	public List<Playlist> getAll() {
		return playlistRepository.findAll();
	}

	@Override
	public List<Playlist> getAllPlaylistByUserId(String id) {
		return playlistRepository.findByUserId(id);
	}

	@Override
	public List<Playlist> getAllFollowPlaylistByUserId(String userId) {
		List<Follow> follows = followRepository.findByUserId(userId);
		List<Playlist> playlists = new ArrayList<Playlist>();
		for (Follow follow : follows) {
			System.out.println(follow.getId().getArtist().getUserId());
			playlists.addAll(playlistRepository.findByUserId(follow.getId().getArtist().getUserId().getUserId()));
		}
		return playlists;
	}

	@Override
	public List<Playlist> getAllPlaylistByCategoryId(int cateId,int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		return playlistRepository.findByCategoryId(cateId,pageable);
	}
	
	@Override
	public List<Playlist> getAllPlaylistByType(int type, int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		return playlistRepository.findByType(type,pageable);
	}

}
