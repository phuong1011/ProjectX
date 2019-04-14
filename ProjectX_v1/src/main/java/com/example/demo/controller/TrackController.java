package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.dto.AlbumDto;
import com.example.demo.dto.TrackDto;
import com.example.demo.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entities.Playlist;
import com.example.demo.entities.Track;
import com.example.demo.service.PlaylistService;
import com.example.demo.service.TrackService;

@Controller
public class TrackController {

	@Autowired
	private TrackService trackService;

	@Autowired
	private PlaylistService playlistService;

	@Autowired
	private AlbumService albumService;

	@RequestMapping(value = "/alltrack/{playListId}", method = RequestMethod.GET)
    public ResponseEntity<List<Track>> listAfffll(@PathVariable int playListId) {
		Playlist palyList = playlistService.findById(playListId);
        if (palyList== null) {
            return new ResponseEntity(null,HttpStatus.NO_CONTENT);
        }
        
        List<Track> list =palyList.getTracks();
        
        return new ResponseEntity<List<Track>>(list, HttpStatus.OK);
    }

	@RequestMapping(value = "/alltrack/album/{albumId}", method = RequestMethod.GET)
	public ResponseEntity<List<Track>> listAllByAlbumId(@PathVariable int albumId) {
		AlbumDto albumDto = albumService.getAlbumById(albumId);
		List<TrackDto> list = albumDto.getTrackList();
		List<Track> list1 = new ArrayList<>();
		for(TrackDto trackDto : list){
			list1.add(trackService.getOneById(trackDto.getTrackId()));
		}

		return new ResponseEntity<List<Track>>(list1, HttpStatus.OK);
	}

	@RequestMapping(value = "/alltrack", method = RequestMethod.GET)
	public ResponseEntity<List<Track>> listAll() {
		List<Track> list = new ArrayList<>();
		list = trackService.getAll();

		if (list.isEmpty()) {
			return new ResponseEntity(null, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Track>>(list, HttpStatus.OK);
	}

	@RequestMapping(value = "/track/{trackId}", method = RequestMethod.GET)
	public ResponseEntity<Track> getTrackById(@PathVariable("trackId") Integer trackId) {
		Track track = new Track();
		track = trackService.getOneById(trackId);

		if (track == null) {
			return new ResponseEntity(null, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Track>(track, HttpStatus.OK);
	}

}
