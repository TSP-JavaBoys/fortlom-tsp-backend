package com.example.fortlomtsp.backend.resource.event;

import com.example.fortlomtsp.backend.resource.artist.ArtistResource;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Setter
@Getter
public class EventResource {

    private Long id;


    private String description;


    private Date registerdate;



    private Long artistid;

    private String name;


    private String ticketLink;


    private Date releasedDate;

    private ArtistResource artist;
}
