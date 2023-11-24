package com.example.fortlomtsp.backend.resource.ForumComment;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter@Setter
public class CreateForumCommentResource {
    private Date registerdate;
    private String commentdescription;
}
