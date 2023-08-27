package com.example.fortlomtsp.backend.resource.publication;
import com.example.fortlomtsp.backend.resource.artist.ArtistResource;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class PublicationResource {
    private Long id;

    private String description;


    private boolean image;

    private Date registerdate;


    private ArtistResource artist;
}
