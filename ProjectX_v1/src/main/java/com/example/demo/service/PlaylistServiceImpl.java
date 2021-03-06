package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Category;
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
			System.out.println(follow.getId().getArtist().getUser());
			playlists.addAll(playlistRepository.findByUserId(follow.getId().getArtist().getUser().getUserId()));
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

	@Override
	public Playlist findById(Integer id) {
		return playlistRepository.findById(id).orElse(null);
	}

	@Override
	public List<Map<String, Object>> getPlaylistCount(int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		List<Map<String, Object>> lst = new ArrayList<Map<String,Object>>();
		List<Playlist> lstPlaylist = playlistRepository.findAll(pageable).getContent();
		
		for (Playlist playlist : lstPlaylist) {
			int count = playlist.getTracks().size();
			playlist.setTracks(null);
			Map<String, Object> mapsMap = new HashMap();
			mapsMap.put("playlist", playlist);
			mapsMap.put("count", count);
			lst.add(mapsMap);
		}
		return lst;
	}

	@Override
	public void addNew(Playlist playList) {
		if(playList!=null) {
			playlistRepository.save(playList);
		}
	}

	@Override
	public Playlist update(Playlist playList) {
		if(playList!=null) {
			Playlist newPL= playlistRepository.getOne(playList.getPlaylistId());
			newPL.setPlaylistName(playList.getPlaylistName());
			newPL.setImagePath(playList.getImagePath());
			newPL.setType(playList.getType());
			newPL.setUserId(playList.getUserId());
			newPL.setCategory(playList.getCategory());
			newPL.setTracks(playList.getTracks());
			playlistRepository.save(newPL);
			return newPL;
		}
		return null;
	}

	@Override
	public void delete(Integer id) {
		Playlist playList = playlistRepository.getOne(id);
		playlistRepository.delete(playList);
	}

}
