package com.example.fortlomtsp.backend.resource.Album;

import com.example.fortlomtsp.backend.domain.model.enumeration.Category;
import com.example.fortlomtsp.backend.resource.artist.ArtistResource;

public class AlbumResource {
    private Long id;
    private String name;
    private String description;
    private ArtistResource artist;
}
