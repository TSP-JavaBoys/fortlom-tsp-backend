package com.example.fortlomtsp.backend.service;

import com.example.fortlomtsp.backend.domain.model.entity.Song;
import com.example.fortlomtsp.backend.domain.persistence.AlbumRepository;
import com.example.fortlomtsp.backend.domain.persistence.SongRepository;
import com.example.fortlomtsp.backend.domain.service.SongService;
import com.example.fortlomtsp.shared.exception.ResourceNotFoundException;
import com.example.fortlomtsp.shared.exception.ResourcePerzonalized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements SongService {
    private static final String ENTITY = "Song";
    private static final String ENTITY2 = "Album";
    @Autowired
    private SongRepository songRepository;

    @Autowired
    private AlbumRepository albumRepository;
    @Override
    public List<Song> getAll() {
        return songRepository.findAll();
    }

    @Override
    public Page<Song> getAll(Pageable pageable) {
        return songRepository.findAll(pageable);
    }

    @Override
    public Song getById(Long songId) {
        return songRepository.findById(songId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, songId));
    }

    @Override
    public void save(Song song) {
        songRepository.save(song);
    }

    @Override
    public Song create(Long albumId, Song request) {
        return albumRepository.findById(albumId)
                .map(album ->{
                    request.setAlbum(album);
                    return songRepository.save(request);
                }).orElseThrow(()->new ResourceNotFoundException("Album", albumId));
    }

    @Override
    public Song update(Long songId, Song request) {
        return songRepository.findById(songId).map(song -> {
            songRepository.save(song);
            return song;
        }).orElseThrow(()->new ResourceNotFoundException(ENTITY, songId));
    }

    @Override
    public ResponseEntity<?> delete(Long songId) {
        return songRepository.findById(songId).map(post -> {
            songRepository.delete(post);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, songId));
    }

    @Override
    public List<Song> getSongByAlbumId(Long albumId) {
        return songRepository.findByAlbumId(albumId);
    }

    @Override
    public Song getbyname(String name) {
        return songRepository.findSongByName(name);
    }

    @Override
    public Song setName(Long songId, Song request) {
        return songRepository.findById(songId).map(post->{
            post.setName(request.getName());
            songRepository.save(post);
            return  post;
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, songId));
    }

    @Override
    public boolean existSong(Long songId) {
        return songRepository.existsById(songId);
    }
}
