package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Playlist;

@Repository("playlistRepository")
public interface PlaylistRepository extends JpaRepository<Playlist, String>{
	public List<Playlist> findAllByUserId(int id);
}
