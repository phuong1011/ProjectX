package com.example.demo.dto;

import java.util.List;

import com.example.demo.entities.Category;
import com.example.demo.entities.Track;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlaylistDto {

	private Integer playlistId;
    private String playlistName;
    private String imagePath;
    private String userId;
    private int type;
    private Category category;
	private List<TrackDto> tracks;
	
}
