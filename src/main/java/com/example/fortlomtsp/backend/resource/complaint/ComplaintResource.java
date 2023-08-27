package com.example.fortlomtsp.backend.resource.complaint;



import com.example.fortlomtsp.backend.resource.publication.PublicationResource;
import com.example.fortlomtsp.backend.resource.useraccoount.UserAccountResource;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class ComplaintResource {

    private Long id;

    private String description;

    private PublicationResource publicationId;

    //private ForumResource forumId;

    //private CommentResource commentId;

    private UserAccountResource userAccountMain;

    private UserAccountResource userAccountReported;
}
