package com.example.fortlomtsp.backend.api;

import com.example.fortlomtsp.backend.domain.model.entity.Album;
import com.example.fortlomtsp.backend.domain.service.AlbumService;
import com.example.fortlomtsp.backend.mapping.AlbumMapper;
import com.example.fortlomtsp.backend.resource.Album.AlbumResource;
import com.example.fortlomtsp.backend.resource.Album.CreateAlbumResource;
import com.example.fortlomtsp.backend.resource.publication.PublicationResource;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/userservice/albums")
public class AlbumController {
    @Autowired
    private AlbumService albumService;

    @Autowired
    private AlbumMapper albumMapper;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public Page<AlbumResource> getAllAlbums(Pageable pageable){
        return albumMapper.modelListToPage(albumService.getAll(), pageable);
    }

    @GetMapping(value = "/{albumId}", produces = "application/json")
    public AlbumResource getAlbumById(@PathVariable("albumId") Long albumId){
        return albumMapper.toResource(albumService.getById(albumId));
    }

    @PostMapping("/artist/{artistId}/newAlbum")
    public ResponseEntity<AlbumResource> createAlbum(@PathVariable Long artistId, @RequestBody CreateAlbumResource request){
        Album album = modelMapper.map(request, Album.class);
        return ResponseEntity.ok(modelMapper.map(albumService.create(artistId, album), AlbumResource.class));
    }

    @DeleteMapping("/albums/{albumId}")
    public ResponseEntity<?> deleteAlbum(@PathVariable Long albumId){
        return albumService.delete(albumId);
    }

    @GetMapping("/artist/{artistId}/albums")
    public ResponseEntity<Page<AlbumResource>> getAllAlbumByArtistId(@PathVariable Long artistId, Pageable pageable){
        return ResponseEntity.ok(albumMapper.modelListToPage(albumService.getAlbumByArtistId(artistId), pageable));
    }

    @GetMapping("albums/check/{albumId}")
    public boolean existsalbum(@PathVariable("albumId") Long albumId){
        return albumService.existAlbum(albumId);
    }
}
