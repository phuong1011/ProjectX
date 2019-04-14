package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.example.demo.dto.AlbumDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entities.Album;
import com.example.demo.service.AlbumService;

@Controller
@CrossOrigin(origins = {"*"})
public class AlbumController {
	
	private AlbumService albumService;

	@Autowired
	public void setAlbumService(AlbumService albumService) {
		this.albumService = albumService;
	}

	@RequestMapping(value = "/album/artist/{artistId}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseEntity<List<AlbumDto>> listAllForUser(@PathVariable("artistId") int id) {
        List<AlbumDto> list = albumService.getAllByUserId(id);
        if (list.isEmpty()) {
            return new ResponseEntity(null,HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<AlbumDto>>(list, HttpStatus.OK);
    }
	

	//Lay ra tat ca cac album duoc tai len moi nhat
	@RequestMapping(value = "/album/date", method = RequestMethod.GET)
	@ResponseBody
    public ResponseEntity<List<AlbumDto>> listAll() {
        List<AlbumDto> list = albumService.getAllOrderByReleaseDate();
        if (list.isEmpty()) {
            return new ResponseEntity(null,HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<AlbumDto>>(list, HttpStatus.OK);
    }
	
	//Lay ra tat ca nhung album cua thang artist ma thang user follow
	@RequestMapping(value = "/album/follow/{userId}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseEntity<List<AlbumDto>> findAllFollowAlbum(@PathVariable("userId") String id) {
        List<AlbumDto> list = albumService.getAllFollowAlbumByUserId(id);
        if (list.isEmpty()) {
            return new ResponseEntity(null,HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<AlbumDto>>(list, HttpStatus.OK);
    }
	
	//Lay ra tat ca nhung album moi nhat theo 1 category
	@RequestMapping(value = "/album/category/{cateId}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseEntity<List<AlbumDto>> findAllAlbumByCategory(@PathVariable("cateId") int categoryId) {
        List<AlbumDto> list = albumService.getAllAlbumByCategoryId(categoryId);
        if (list.isEmpty()) {
            return new ResponseEntity(null,HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<AlbumDto>>(list, HttpStatus.OK);
    }
	
	//Lay ra 10 random album
	@RequestMapping(value = "/album/random-ten", method = RequestMethod.GET)
    public ResponseEntity<List<AlbumDto>> listRandomTen() {
		Random rand = new Random();
		List<AlbumDto> list = new ArrayList<AlbumDto>();
			List<AlbumDto> allList = albumService.getAll();
			if(allList.size()<=10) {
				list = allList;
			}else {
				do {
					int randomIndex = rand.nextInt(allList.size());
			        AlbumDto randomElement = allList.get(randomIndex);
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
				} while(list.size() < 10);
			}
			if (list.isEmpty()) {
	            return new ResponseEntity(null,HttpStatus.NO_CONTENT);
	        }
	        return new ResponseEntity<List<AlbumDto>>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/album/{id}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseEntity<AlbumDto> findById(@PathVariable("id") int id) {
        AlbumDto list = albumService.getAlbumById(id);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/album", method = RequestMethod.POST)
	@ResponseBody
    public ResponseEntity<AlbumDto> saveAlbum(@RequestBody AlbumDto albumDto) {
        AlbumDto album1 = albumService.saveAlbum(albumDto);
        return new ResponseEntity<>(album1, HttpStatus.OK);
    }
}
