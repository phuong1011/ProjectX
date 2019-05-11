package com.example.demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.demo.dto.PlaylistDto;
import com.example.demo.entities.Playlist;

@Mapper(componentModel = "spring")
public interface PlaylistMapper {
	PlaylistMapper MAPPER = Mappers.getMapper(PlaylistMapper.class);

    @Mapping(source = "tracks",target = "tracks")
    PlaylistDto toDto(Playlist playlist);

    @Mapping(source = "tracks",target = "tracks")
    Playlist toEntity(PlaylistDto playlistDto);
}
