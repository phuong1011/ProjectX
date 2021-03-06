package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Artist;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Integer> {
	List<Artist> findByartistNameContaining(String name);

	@Query("SELECT u FROM Artist u WHERE u.user.userId = ?1")
	Artist findByUserId(String userId);
}
