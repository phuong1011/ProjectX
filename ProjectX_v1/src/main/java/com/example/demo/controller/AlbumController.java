package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Random;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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


	@RequestMapping(value = "/album/date", method = RequestMethod.GET)
	@ResponseBody
    public ResponseEntity<List<Album>> listAll() {
        List<Album> list = albumService.getAllOrderByReleaseDate();
        if (list.isEmpty()) {
            return new ResponseEntity(null,HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Album>>(list, HttpStatus.OK);
    }
}
