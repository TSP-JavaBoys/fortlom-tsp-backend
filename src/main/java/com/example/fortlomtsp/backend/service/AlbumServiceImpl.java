package com.example.fortlomtsp.backend.service;

import com.example.fortlomtsp.backend.domain.model.entity.Album;
import com.example.fortlomtsp.backend.domain.persistence.AlbumRepository;
import com.example.fortlomtsp.backend.domain.persistence.ArtistRepository;
import com.example.fortlomtsp.backend.domain.service.AlbumService;
import com.example.fortlomtsp.shared.exception.ResourceNotFoundException;
import com.example.fortlomtsp.shared.exception.ResourcePerzonalized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class AlbumServiceImpl implements AlbumService {
    private static final String ENTITY = "Album";
    private static final String ENTITY2 = "Artist";

    @Autowired
    private AlbumRepository albumRepository;
    @Autowired
    private ArtistRepository artistRepository;

    @Override
    public List<Album> getAll() {
        return albumRepository.findAll();
    }

    @Override
    public Page<Album> getAll(Pageable pageable) {
        return albumRepository.findAll(pageable);
    }

    @Override
    public Album getById(Long albumId) {
        return albumRepository.findById(albumId).orElseThrow(() -> new ResourceNotFoundException(ENTITY, albumId));
    }

    @Override
    public Album create(Long artistId, Album request) {
        return artistRepository.findById(artistId)
                .map(artist -> {
                    request.setArtist(artist);
                    return albumRepository.save(request);
                })
                .orElseThrow(()-> new ResourceNotFoundException("Artist", artistId));
    }

    @Override
    public Album update(Long albumId, Album request) {
        return albumRepository.findById(albumId).map(
                album -> {
                    albumRepository.save(album);
                    return album;
                }).orElseThrow(()-> new ResourceNotFoundException(ENTITY, albumId));
    }

    @Override
    public List<Album> getAlbumByArtistId(Long artistId) {
        return albumRepository.findByArtistId(artistId);
    }


    @Override
    public ResponseEntity<?> delete(Long albumId) {
        return albumRepository.findById(albumId).map(post -> {
            albumRepository.delete(post);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, albumId));
    }

    @Override
    public Album getbyname(String name) {
        return albumRepository.findAlbumByName(name);
    }

    @Override
    public Album setname(Long albumId, Album request) {
        return albumRepository.findById(albumId).map(post->{
            post.setName(request.getName());
            albumRepository.save(post);
            return  post;
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, albumId));
    }

    @Override
    public boolean existAlbum(Long albumId) {
        return albumRepository.existsById(albumId);
    }
}
