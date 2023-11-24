package com.example.fortlomtsp.backend.resource.PublicationComment;



import com.example.fortlomtsp.backend.resource.publication.PublicationResource;
import com.example.fortlomtsp.backend.resource.useraccoount.UserAccountResource;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Transient;
import java.util.Date;

@Getter
@Setter
public class PublicationCommentResource {
    private Long id;

    private Date registerdate;


    private UserAccountResource userAccount;
    private String commentdescription;


    private PublicationResource publication;
}
