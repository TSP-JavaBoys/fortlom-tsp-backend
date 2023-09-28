package com.example.fortlomtsp.backend.domain.service;

import com.example.fortlomtsp.backend.domain.model.entity.Album;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AlbumService {
    List<Album> getAll();
    Album getById(Long albumId);
    void save(Album album);
    Album create(Album album);
    ResponseEntity<?> delete(Long albumId);
    Album getbyname(String name);
    Album setname(Long albumId,Album request);
}
