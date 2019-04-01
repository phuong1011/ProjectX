package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entities.Artist;
import com.example.demo.entities.Track;
import com.example.demo.service.ArtistService;
import com.example.demo.service.TrackService;

@Controller
@RequestMapping("/search")
public class SearchController {
	
	private TrackService trackService;
	
	private ArtistService artistService;
	
	@Autowired
	public void setArtistService(ArtistService artistService) {
		this.artistService = artistService;
	}

	@Autowired
	public void setTrackService(TrackService trackService) {
		this.trackService = trackService;
	}
	
	@RequestMapping(value = "/track/{trackName}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseEntity<List<Track>> getTrackByName(@PathVariable("trackName") String trackName) {
		List<Track> tracks = new ArrayList<Track>();
			tracks = trackService.FindByName(trackName);
        
		if (tracks == null) {
            return new ResponseEntity(null,HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Track>>(tracks, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/artist/{artistName}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseEntity<List<Artist>> getArtistByName(@PathVariable("artistName") String artistName) {
		List<Artist> artists = new ArrayList<Artist>();
		artists = artistService.FindByName(artistName);
        
		if (artists == null) {
            return new ResponseEntity(null,HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Artist>>(artists, HttpStatus.OK);
    }
}
