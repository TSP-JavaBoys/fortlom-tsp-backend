package com.example.fortlomtsp.backend.resource.Image;


import com.example.fortlomtsp.backend.domain.model.entity.Publication;
import com.example.fortlomtsp.backend.domain.model.entity.UserAccount;
import com.example.fortlomtsp.backend.resource.publication.PublicationResource;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class ImageResource {

    private Long id;
    private String imagenUrl;
    private UserAccount userid;
    private String imagenId;
    private PublicationResource publicationid;
}
