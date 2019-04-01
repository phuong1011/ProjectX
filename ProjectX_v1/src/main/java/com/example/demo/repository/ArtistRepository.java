package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Artist;

@Repository("artistRepository")
public interface ArtistRepository extends JpaRepository<Artist, Integer> {
	List<Artist> findByartistNameContaining(String name);
}
