package com.example.fortlomtsp.backend.domain.service;

import com.example.fortlomtsp.backend.domain.model.entity.Song;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SongService {
    List<Song> getAll();
    Song getById(Long songId);
    void save(Song song);
    Song create(Song song);
    ResponseEntity<?> delete(Long songId);
    Song getbyname(String name);
    Song setName(Long songId,Song request);
}
