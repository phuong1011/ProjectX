package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entities.Category;
import com.example.demo.service.CategoryService;

@Controller
@CrossOrigin(origins = {"*"})
public class CategoryController {

	private CategoryService categoryService;
	
	private Logger logger;

	@Autowired
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	@RequestMapping(value = "/category", method = RequestMethod.GET)
	@ResponseBody
    public ResponseEntity<List<Category>> listAll() {
		List<Category> list = new ArrayList<>();
		try {
			list = categoryService.getAll();
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
        
        if (list.isEmpty()) {
            return new ResponseEntity(null,HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Category>>(list, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/category", method = RequestMethod.POST)
	@ResponseBody
    public ResponseEntity<Void> addNew(@RequestBody Category category) {
		try {
			categoryService.addNew(category);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
	
	@RequestMapping(value = "/category", method = RequestMethod.PUT)
	@ResponseBody
    public ResponseEntity<Category> update(@RequestBody Category category) {
		Category cate = new Category();
		try {
			cate = categoryService.update(category);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return new ResponseEntity<Category>(cate, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/category/{id}", method = RequestMethod.DELETE)
	@ResponseBody
    public ResponseEntity<Category> delete(@PathVariable Integer id) {
		try {
			categoryService.delete(id);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return new ResponseEntity<Category>(HttpStatus.NO_CONTENT);
    }
	
	
}
