package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Album;

@Repository("albumRepository")
public interface AlbumRepository extends JpaRepository<Album, Integer> {
	List<Album> findAllByOrderByReleaseDateDesc();
}
