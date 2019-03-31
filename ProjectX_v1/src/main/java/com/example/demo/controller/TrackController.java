package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.Track;
import com.example.demo.service.TrackService;

@Controller
public class TrackController {

	private TrackService trackService;

	@Autowired
	public void setTrackService(TrackService trackService) {
		this.trackService = trackService;
	}
	
	@RequestMapping(value = "/alltrack", method = RequestMethod.GET)
    public ResponseEntity<List<Track>> listAll() {
		List<Track> list = new ArrayList<>();
			list = trackService.getAll();
        
        if (list.isEmpty()) {
            return new ResponseEntity(null,HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Track>>(list, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/track/{trackId}", method = RequestMethod.GET)
    public ResponseEntity<Track> getTrackById(@PathVariable("trackId")Integer trackId) {
		Track track = new Track();
			track = trackService.getOneById(trackId);
        
		if (track == null) {
            return new ResponseEntity(null,HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Track>(track, HttpStatus.OK);
    }
	
	
	
}
