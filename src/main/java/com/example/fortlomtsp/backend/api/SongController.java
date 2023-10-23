package com.example.fortlomtsp.backend.api;

import com.example.fortlomtsp.backend.domain.model.entity.Song;
import com.example.fortlomtsp.backend.domain.service.SongService;
import com.example.fortlomtsp.backend.mapping.SongMapper;
import com.example.fortlomtsp.backend.resource.Album.AlbumResource;
import com.example.fortlomtsp.backend.resource.Song.CreateSongResource;
import com.example.fortlomtsp.backend.resource.Song.SongResource;
import io.swagger.models.Response;
import org.checkerframework.checker.units.qual.A;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/userservice/albums/songs")
public class SongController {
    @Autowired
    private SongService songService;

    @Autowired
    private SongMapper songMapper;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/songs")
    public Page<SongResource> getAllSongs(Pageable pageable){
        return songMapper.modelListToPage(songService.getAll(), pageable);
    }

    @GetMapping("/songs/{songId}")
    public SongResource getSongById(@PathVariable("songId") Long songId){
        return songMapper.toResource(songService.getById(songId));
    }

    @PostMapping("/album/{albumId}/type/{type}/songs")
    public ResponseEntity<SongResource> createSong(@PathVariable Long albumId, @PathVariable String type, @RequestBody CreateSongResource request){
        Song song = modelMapper.map(request, Song.class);
        return ResponseEntity.ok(modelMapper.map(songService.create(albumId, song,type), SongResource.class));
    }

    @DeleteMapping("/songs/{songId}")
    public ResponseEntity<?> deleteSong(@PathVariable Long songId){
        return songService.delete(songId);
    }

    @GetMapping("/albums/{albumId}/songs")
    public ResponseEntity<Page<SongResource>> getAllSongByAlbumId(@PathVariable Long albumId, Pageable pageable){
        return ResponseEntity.ok(songMapper.modelListToPage(songService.getSongByAlbumId(albumId), pageable));
    }

    @GetMapping("/songs/check/{songId}")
    public boolean existssong(@PathVariable("songId") Long songId){
        return songService.existSong(songId);
    }

}
