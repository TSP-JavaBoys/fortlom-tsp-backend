package com.example.fortlomtsp.backend.domain.service;

import com.example.fortlomtsp.backend.domain.model.entity.Album;
import com.example.fortlomtsp.backend.domain.model.entity.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SongService {
    List<Song> getAll();
    Page<Song> getAll(Pageable pageable);
    Song getById(Long songId);
    void save(Song song);
    Song create(Long albumId, Song request);
    Song update(Long songId, Song request);
    ResponseEntity<?> delete(Long songId);
    List<Song> getSongByAlbumId(Long albumId);
    Song getbyname(String name);
    Song setName(Long songId,Song request);
    boolean existSong(Long songId);
}
