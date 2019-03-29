package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Track;
import com.example.demo.entities.User;

@Repository("trackRepository")
public interface TrackRepository extends JpaRepository<Track, String>{
	public Track findByTrackId(Integer id);
}
