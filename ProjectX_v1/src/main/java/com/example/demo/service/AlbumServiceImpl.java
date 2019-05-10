package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import com.example.demo.dto.AlbumDto;
import com.example.demo.dto.TrackDto;
import com.example.demo.mapper.AlbumMapper;
import com.example.demo.mapper.TrackMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Album;
import com.example.demo.entities.Follow;
import com.example.demo.entities.Track;
import com.example.demo.repository.AlbumRepository;
import com.example.demo.repository.ArtistRepository;
import com.example.demo.repository.FollowRepository;
import com.example.demo.repository.TrackRepository;

@Service("albumService")
public class AlbumServiceImpl implements AlbumService {

	@Autowired
	private AlbumRepository albumRepository;

	@Autowired
	private FollowRepository followRepository;

	@Autowired
	private TrackRepository trackRepository;

	@Override
	public List<AlbumDto> getAll() {
		return albumRepository.findAll().stream()
				.map(album -> AlbumMapper.MAPPER.toDto(album))
				.collect(Collectors.toList());
	}

	@Override
	public List<AlbumDto> getAllOrderByReleaseDate() {
		List<Album> albums = albumRepository.findAllByOrderByReleaseDateDesc();
		return albums
				.stream()
				.map(album -> AlbumMapper.MAPPER.toDto(album))
				.collect(Collectors.toList());
	}

	@Override
	public List<AlbumDto> getAllFollowAlbumByUserId(String userId) {
		List<Follow> follows = followRepository.findByUserId(userId);
		List<Album> albums = new ArrayList<Album>();
		for (Follow follow : follows) {
			System.out.println(follow.getId().getArtist().getArtistId());
			albums.addAll(albumRepository.findByArtistId(follow.getId().getArtist().getArtistId()));
		}
		return albums.stream()
				.map(album -> AlbumMapper.MAPPER.toDto(album))
				.collect(Collectors.toList());
	}

	@Override
	public List<AlbumDto> getAllAlbumByCategoryId(int cateId) {
		return albumRepository.findByCategoryId(cateId).stream()
				.map(album -> AlbumMapper.MAPPER.toDto(album))
				.collect(Collectors.toList());
	}

	@Override
	public AlbumDto getAlbumById(int id) {
		return AlbumMapper.MAPPER.toDto(albumRepository.getOne(id));
	}

	@Override
	public List<AlbumDto> getAllByUserId(int artistId) {
		return albumRepository.findByArtistId(artistId).stream()
				.map(album -> AlbumMapper.MAPPER.toDto(album))
				.collect(Collectors.toList());
	}

	@Override
	@Transactional
	public AlbumDto saveAlbum(AlbumDto albumDto) {
		List<TrackDto> lst = albumDto.getTrackList();
		Album album = AlbumMapper.MAPPER.toEntity(albumDto);
		album.setTrackList(null);
		Album album1 =  albumRepository.save(album);
		if(lst != null) {
            for (TrackDto trackDto : lst) {
                Track track = TrackMapper.MAPPER.toEntity(trackDto);
                track.setAlbum(album1);
                trackRepository.save(track);
            }
        }
		return AlbumMapper.MAPPER.toDto(album1);
	}

    @Override
    public void deleteAlbum(int id) {
        albumRepository.deleteById(id);
    }


}
