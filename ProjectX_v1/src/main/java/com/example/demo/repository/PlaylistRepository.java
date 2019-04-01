package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Playlist;

@Repository("playlistRepository")
public interface PlaylistRepository extends JpaRepository<Playlist, String>{
	List<Playlist> findByUserId(String userId);
	
	@Query("SELECT u FROM Playlist u WHERE u.category.categoryId = ?1")
	List<Playlist> findByCategoryId(int cateId);
	
	List<Playlist> findByType(int type);
}
