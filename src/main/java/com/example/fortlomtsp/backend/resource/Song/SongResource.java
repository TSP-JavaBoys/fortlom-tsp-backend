package com.example.fortlomtsp.backend.resource.Song;

import com.example.fortlomtsp.backend.resource.Album.AlbumResource;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SongResource {
    Long id;
    String name;
    String musicUrl;
    String category;
    private AlbumResource albumResource;
}
