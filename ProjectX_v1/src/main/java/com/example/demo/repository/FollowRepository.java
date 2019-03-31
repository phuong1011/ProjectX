package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Follow;
import com.example.demo.entities.Follow_Id;

@Repository
public interface FollowRepository extends JpaRepository<Follow, Follow_Id> {
	@Query("SELECT u FROM Follow u WHERE u.Id.user.userId = ?1")
	List<Follow> findByUserId(String userId);
}
