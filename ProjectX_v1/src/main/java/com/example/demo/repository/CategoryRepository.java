package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Category;

@Repository("categoryRepository")
public interface CategoryRepository extends JpaRepository<Category, String>{
	Category findByCategoryId(Integer id);
}
