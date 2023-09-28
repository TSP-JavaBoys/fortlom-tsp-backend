package com.example.fortlomtsp.backend.service;

import com.example.fortlomtsp.backend.domain.model.entity.Song;
import com.example.fortlomtsp.backend.domain.persistence.SongRepository;
import com.example.fortlomtsp.backend.domain.service.SongService;
import com.example.fortlomtsp.shared.exception.ResourceNotFoundException;
import com.example.fortlomtsp.shared.exception.ResourcePerzonalized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements SongService {
    private static final String ENTITY = "Song";
    @Autowired
    private SongRepository songRepository;
    @Override
    public List<Song> getAll() {
        return songRepository.findAll();
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
    public Song create(Song song) {
        if(songRepository.existsByName(song.getName()))
            throw  new ResourcePerzonalized("ya exsite este nombre de canción");
        if (songRepository.existsByMusicUrl(song.getMusicUrl()))
            throw  new ResourcePerzonalized("ya exsite este Url");

        return songRepository.save(song);
    }

    @Override
    public ResponseEntity<?> delete(Long songId) {
        return songRepository.findById(songId).map(post -> {
            songRepository.delete(post);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, songId));
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
}
