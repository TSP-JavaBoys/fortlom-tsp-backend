package com.example.fortlomtsp.backend.service;

import com.example.fortlomtsp.backend.domain.model.entity.Album;
import com.example.fortlomtsp.backend.domain.persistence.AlbumRepository;
import com.example.fortlomtsp.backend.domain.service.AlbumService;
import com.example.fortlomtsp.shared.exception.ResourceNotFoundException;
import com.example.fortlomtsp.shared.exception.ResourcePerzonalized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AlbumServiceImpl implements AlbumService {
    private static final String ENTITY = "Album";
    @Autowired
    private AlbumRepository albumRepository;

    @Override
    public List<Album> getAll() {
        return albumRepository.findAll();
    }

    @Override
    public Album getById(Long albumId) {
        return albumRepository.findById(albumId).orElseThrow(() -> new ResourceNotFoundException(ENTITY, albumId));
    }

    @Override
    public void save(Album album) {
        albumRepository.save(album);
    }

    @Override
    public Album create(Album album) {
        if(albumRepository.existsByName(album.getName()))
            throw  new ResourcePerzonalized("ya exsite este nombre de álbum");
        if (albumRepository.existsById(album.getId()))
            throw  new ResourcePerzonalized("ya exsite un album con el mismo Id");

        return albumRepository.save(album);
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
}
