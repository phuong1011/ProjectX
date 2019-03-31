package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Album;

@Repository("albumRepository")
public interface AlbumRepository extends JpaRepository<Album, Integer> {
	List<Album> findAllByOrderByReleaseDateDesc();
	
	@Query("SELECT u FROM Album u WHERE u.artist.artistId = ?1")
	List<Album> findByArtistId(int artist);
	
	@Query("SELECT u FROM Album u WHERE u.category.categoryId = ?1")
	List<Album> findByCategoryId(int categoryId);
}
