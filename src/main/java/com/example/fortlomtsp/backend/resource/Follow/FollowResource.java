package com.example.fortlomtsp.backend.resource.Follow;

import com.example.fortlomtsp.backend.resource.artist.ArtistResource;
import com.example.fortlomtsp.backend.resource.fanatic.FanaticResource;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class FollowResource {

    private Long id;

    private ArtistResource artist;


    private FanaticResource fanatic;
}
