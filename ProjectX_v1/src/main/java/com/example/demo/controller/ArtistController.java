package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entities.Artist;
import com.example.demo.service.ArtistService;

@Controller
@CrossOrigin(origins = {"*"})
public class ArtistController {

	@Autowired
	private ArtistService artistService;
	
	@RequestMapping(value = "/artist/{id}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseEntity<Artist> findById(@PathVariable("id") int id) {
		Artist artist = artistService.findById(id);
        return new ResponseEntity<>(artist, HttpStatus.OK);
    }

	@RequestMapping(value = "/artist/userid/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Artist> findByUserId(@PathVariable("id") String userId) {
		Artist artist = artistService.FindByUserId(userId);
		return new ResponseEntity<>(artist, HttpStatus.OK);
	}

	@PostMapping(value = "/artist")
	@ResponseBody
	public ResponseEntity<Artist> save(@RequestBody Artist artist) {
		Artist artist1 = artistService.save(artist);
		return new ResponseEntity<>(artist1, HttpStatus.OK);
	}
}
