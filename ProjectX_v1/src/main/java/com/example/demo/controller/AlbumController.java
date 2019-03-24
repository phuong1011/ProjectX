package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entities.Album;
import com.example.demo.service.AlbumService;

@Controller
public class AlbumController {

	private AlbumService albumService;
	
	private Logger logger;
	
	@Autowired
	public void setAlbumService(AlbumService albumService) {
		this.albumService = albumService;
	}


	@RequestMapping(value = "/album", method = RequestMethod.GET)
    public ResponseEntity<List<Album>> listAll() {
		List<Album> list = new ArrayList<>();
		try {
			list = albumService.getAll();
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
        
        if (list.isEmpty()) {
            return new ResponseEntity(null,HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Album>>(list, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/album-ten", method = RequestMethod.GET)
    public ResponseEntity<List<Album>> listRandomTen() {
		Random rand = new Random();
		List<Album> list = new ArrayList<Album>();
		try {
			List<Album> allList = albumService.getAll();
			for (int i = 0; i < 10; i++) {
		        int randomIndex = rand.nextInt(allList.size());
		        Album randomElement = allList.get(randomIndex);
		        if(list == null || (list != null && list.isEmpty())){
	        		list.add(randomElement);
	        	}else {
	        		boolean nothave = true;
	        		for(int j = 0;j<list.size();j++)
			        {
	        			if(randomElement.getAlbumId()==list.get(j).getAlbumId()) {
	        				nothave = false;
			        	}
			        }
	        		if(nothave) {
	        			list.add(randomElement);
	        		}
	        	}
		        
		    }
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
        
        if (list.isEmpty()) {
            return new ResponseEntity(null,HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Album>>(list, HttpStatus.OK);
    }
}
