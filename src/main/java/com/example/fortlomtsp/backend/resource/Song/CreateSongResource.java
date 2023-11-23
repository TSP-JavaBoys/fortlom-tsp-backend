package com.example.fortlomtsp.backend.resource.Song;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateSongResource {
    String name;
    String musicUrl;
    String category;
}
