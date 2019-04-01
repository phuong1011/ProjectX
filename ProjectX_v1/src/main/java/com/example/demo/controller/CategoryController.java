package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entities.Category;
import com.example.demo.service.CategoryService;

@Controller
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
    public void addNew(@RequestBody Category category) {
		try {
			categoryService.addNew(category);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
    }
	
	@RequestMapping(value = "/category", method = RequestMethod.PUT)
	@ResponseBody
    public void update(Category category) {
		try {
			categoryService.update(category);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
    }
	
	@RequestMapping(value = "/category", method = RequestMethod.DELETE)
	@ResponseBody
    public void delete(int id) {
		try {
			categoryService.delete(id);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
    }
	
	
}
