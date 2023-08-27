package com.example.fortlomtsp.backend.resource.Rate;

import com.example.fortlomtsp.backend.resource.artist.ArtistResource;
import com.example.fortlomtsp.backend.resource.fanatic.FanaticResource;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class RateResource {


    private Long id;


    private Float review;


    private ArtistResource artistid;


    private FanaticResource fanaticid;
}

