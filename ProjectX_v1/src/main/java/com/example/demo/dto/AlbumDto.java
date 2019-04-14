package com.example.demo.dto;

import com.example.demo.entities.Artist;
import com.example.demo.entities.Category;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AlbumDto {
    private Integer albumId;
    private String albumName;
    private String imagePath;
    private Date releaseDate;
    private Category category;
    private Artist artist;
    private List<TrackDto> trackList;

}
