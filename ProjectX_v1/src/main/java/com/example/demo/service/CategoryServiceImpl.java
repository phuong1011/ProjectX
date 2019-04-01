package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Category;
import com.example.demo.repository.CategoryRepository;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService{

	private CategoryRepository categoryRepository;

	@Autowired
	public void setCategoryRepository(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
	@Override
	public List<Category> getAll() {
		return categoryRepository.findAll();
	}

	@Override
	public void addNew(Category category) {
		if(category!=null) {
			categoryRepository.save(category);
		}	
	}

	@Override
	public void update(Category category) {
		if(category!=null) {
			categoryRepository.save(category);
		}
	}

	@Override
	public void delete(int id) {
		categoryRepository.deleteById(id);
	}
	
}
