package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entities.Playlist;
import com.example.demo.service.PlaylistService;

@Controller
public class PlaylistController {

	private PlaylistService playlistService;
	
	private Logger logger;

	@Autowired
	public void setPlaylistService(PlaylistService playlistService) {
		this.playlistService = playlistService;
	}
	
	//Lay ra tat ca cac play list
	@RequestMapping(value = "/playlist", method = RequestMethod.GET)
    public ResponseEntity<List<Playlist>> listAll() {
		List<Playlist> list = new ArrayList<>();
		try {
			list = playlistService.getAll();
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
        
        if (list.isEmpty()) {
            return new ResponseEntity(null,HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Playlist>>(list, HttpStatus.OK);
    }

	
	//Lay ra tat ca cac playlist cua cac artist ma thang user follow
	@RequestMapping(value = "/playlist/follow/{userId}", method = RequestMethod.GET)
    public ResponseEntity<List<Playlist>> playlistFollowByUserId(@PathVariable("userId") String userId) {
		List<Playlist> list = new ArrayList<>();
		try {
			list = playlistService.getAllFollowPlaylistByUserId(userId);
		} catch (Exception e) {
			System.out.println(e);
			logger.info(e.getMessage());
		}
        
        if (list.isEmpty()) {
            return new ResponseEntity(null,HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Playlist>>(list, HttpStatus.OK);
        
    }
	
	@RequestMapping(value = "/playlist/category/{cateId}", method = RequestMethod.GET)
    public ResponseEntity<List<Playlist>> playlistByUserId(@PathVariable("cateId") int cateId,@RequestParam(value = "page", required = false, defaultValue = "0") int page
    		, @RequestParam(value = "size", required = false, defaultValue = "10") int size) {
		List<Playlist> list = new ArrayList<>();
		try {
			list = playlistService.getAllPlaylistByCategoryId(cateId,page,size);
		} catch (Exception e) {
			System.out.println(e);
			logger.info(e.getMessage());
		}
        
        if (list.isEmpty()) {
            return new ResponseEntity(null,HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Playlist>>(list, HttpStatus.OK);
        
    }
	
	//Lay ra cac playlist duoc tao ra boi admin
	@RequestMapping(value = "/playlist/admin", method = RequestMethod.GET)
    public ResponseEntity<List<Playlist>> playlistByAdmin(@RequestParam(value = "page", required = false, defaultValue = "0") int page
    		, @RequestParam(value = "size", required = false, defaultValue = "10") int size) {
		List<Playlist> list = new ArrayList<>();
		try {
			list = playlistService.getAllPlaylistByType(0, page, size);
		} catch (Exception e) {
			System.out.println(e);
			logger.info(e.getMessage());
		}
        
        if (list.isEmpty()) {
            return new ResponseEntity(null,HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Playlist>>(list, HttpStatus.OK);
        
    }
	
	@RequestMapping(value = "/playlist/count", method = RequestMethod.GET)
	@ResponseBody
    public ResponseEntity<List<Map<String, Object>>> playlistWithCount(@RequestParam(value = "page", required = false, defaultValue = "0") int page
    		, @RequestParam(value = "size", required = false, defaultValue = "10") int size) {
		List<Map<String, Object>> lst = new ArrayList<Map<String,Object>>();
		lst = playlistService.getPlaylistCount(page, size);
        
        if (lst.isEmpty()) {
            return new ResponseEntity(null,HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(lst, HttpStatus.OK);
        
    }
	
}
