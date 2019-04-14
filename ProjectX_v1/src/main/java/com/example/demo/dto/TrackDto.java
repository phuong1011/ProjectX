package com.example.demo.dto;


import com.example.demo.entities.Artist;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TrackDto {
    private Integer trackId;
    private String trackName;
    private long duration;
    private String audioPath;
    private int size;
    private String description;
    private String userUploadId;
    private List<Artist> artists;
}
