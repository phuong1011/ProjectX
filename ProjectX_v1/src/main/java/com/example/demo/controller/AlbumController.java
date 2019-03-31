package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entities.Album;
import com.example.demo.service.AlbumService;

@Controller
public class AlbumController {
	
	private AlbumService albumService;

	@Autowired
	public void setAlbumService(AlbumService albumService) {
		this.albumService = albumService;
	}


	//Lay ra tat ca cac album duoc tai len moi nhat
	@RequestMapping(value = "/album/date", method = RequestMethod.GET)
	@ResponseBody
    public ResponseEntity<List<Album>> listAll() {
        List<Album> list = albumService.getAllOrderByReleaseDate();
        if (list.isEmpty()) {
            return new ResponseEntity(null,HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Album>>(list, HttpStatus.OK);
    }
	
	//Lay ra tat ca nhung album cua thang artist ma thang user follow
	@RequestMapping(value = "/album/follow/{userId}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseEntity<List<Album>> findAllFollowAlbum(@PathVariable("userId") String id) {
        List<Album> list = albumService.getAllFollowAlbumByUserId(id);
        if (list.isEmpty()) {
            return new ResponseEntity(null,HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Album>>(list, HttpStatus.OK);
    }
	
	//Lay ra tat ca nhung album moi nhat theo 1 category
	@RequestMapping(value = "/album/category/{cateId}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseEntity<List<Album>> findAllAlbumByCategory(@PathVariable("cateId") int categoryId) {
        List<Album> list = albumService.getAllAlbumByCategoryId(categoryId);
        if (list.isEmpty()) {
            return new ResponseEntity(null,HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Album>>(list, HttpStatus.OK);
    }
}
