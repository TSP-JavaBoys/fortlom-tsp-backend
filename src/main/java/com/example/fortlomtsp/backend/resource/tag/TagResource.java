package com.example.fortlomtsp.backend.resource.tag;

import com.example.fortlomtsp.backend.resource.artist.ArtistResource;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TagResource {
    private Long id;

    private String name;

    private ArtistResource artist;
}
