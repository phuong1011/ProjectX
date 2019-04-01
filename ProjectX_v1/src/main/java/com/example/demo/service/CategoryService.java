package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Category;

public interface CategoryService {
	public List<Category> getAll();
	public void addNew(Category category);
	public void update(Category category);
	public void delete(int id);
}
