package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entities.Artist;
import com.example.demo.service.ArtistService;

@Controller
public class ArtistController {

	@Autowired
	private ArtistService artistService;
	
	@RequestMapping(value = "/artist/{id}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseEntity<Artist> findById(@PathVariable("id") int id) {
		Artist artist = artistService.findById(id);
        return new ResponseEntity<>(artist, HttpStatus.OK);
    }
}
