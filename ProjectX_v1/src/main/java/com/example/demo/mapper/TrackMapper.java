package com.example.demo.mapper;

import com.example.demo.dto.TrackDto;
import com.example.demo.entities.Track;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TrackMapper {
    TrackMapper MAPPER = Mappers.getMapper(TrackMapper.class);

    //@Mapping(source = "trackList",target = "trackList")
    TrackDto toDto(Track track);

    Track toEntity(TrackDto trackDto);
}
