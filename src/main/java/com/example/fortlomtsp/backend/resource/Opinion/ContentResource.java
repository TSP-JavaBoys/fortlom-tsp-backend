package com.example.fortlomtsp.backend.resource.Opinion;

import com.example.fortlomtsp.backend.domain.model.entity.Artist;
import com.example.fortlomtsp.backend.resource.artist.ArtistResource;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
public class ContentResource {

    private Long id;


    private String description;


    private Date registerdate;


    private ArtistResource artist;
}
