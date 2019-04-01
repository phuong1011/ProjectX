package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Track;
import com.example.demo.entities.User;


@Repository("trackRepository")
public interface TrackRepository extends JpaRepository<Track, String>{
	Track findByTrackId(Integer id);
	
	List<Track> findBytrackNameContaining(String name);
}
