package com.example.fortlomtsp.backend.resource.Album;

import com.example.fortlomtsp.backend.domain.model.enumeration.Category;
import com.example.fortlomtsp.backend.resource.artist.ArtistResource;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlbumResource {
    private Long id;
    private String name;
    private String description;
    private ArtistResource artist;
}
