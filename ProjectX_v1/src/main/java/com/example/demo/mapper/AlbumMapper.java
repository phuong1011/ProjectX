package com.example.demo.mapper;

import com.example.demo.dto.AlbumDto;
import com.example.demo.entities.Album;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AlbumMapper {
    AlbumMapper MAPPER = Mappers.getMapper(AlbumMapper.class);

    @Mapping(source = "trackList",target = "trackList")
    AlbumDto toDto(Album album);

    @Mapping(source = "trackList",target = "trackList")
    Album toEntity(AlbumDto albumDto);
}
