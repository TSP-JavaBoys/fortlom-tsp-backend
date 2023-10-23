package com.example.fortlomtsp.backend.domain.service;

import com.example.fortlomtsp.backend.domain.model.entity.Album;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AlbumService {
    List<Album> getAll();
    Page<Album> getAll(Pageable pageable);
    Album getById(Long albumId);
    Album create(Long artistId, Album request, String type);
    Album update(Long albumId, Album request);
    List<Album> getAlbumByArtistId(Long artistId);
    ResponseEntity<?> delete(Long albumId);
    Album getbyname(String name);
    Album setname(Long albumId,Album request);
    boolean existAlbum(Long albumId);
}
