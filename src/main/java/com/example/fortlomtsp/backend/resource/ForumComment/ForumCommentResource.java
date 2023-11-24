package com.example.fortlomtsp.backend.resource.ForumComment;



import com.example.fortlomtsp.backend.resource.useraccoount.UserAccountResource;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import java.util.Date;

@Setter
@Getter
public class ForumCommentResource {

    private Long id;

    private Date registerdate;
    private String commentdescription;

    private UserAccountResource userAccount;


    //private ForumResource forum;
}
