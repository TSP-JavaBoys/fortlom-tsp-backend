package com.example.fortlomtsp.backend.domain.model.entity;


import com.example.fortlomtsp.backend.domain.model.entity.UserAccount;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@NoArgsConstructor
@Getter
@Setter
@Entity
@With
@AllArgsConstructor
@Table(name="complaints")
public class Complaint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 200)
    private String description;

    @ManyToOne(targetEntity = Publication.class)
    @JoinColumn(name = "publicationid")
    private Publication publicationId;

    @ManyToOne(targetEntity = Forum.class)
    @JoinColumn(name = "forumid")
    private Forum forumId;

    @ManyToOne(targetEntity = Comment.class)
    @JoinColumn(name = "commentid")
    private Comment commentId;

    @ManyToOne(targetEntity = UserAccount.class)
    @JoinColumn(name = "userMainid")
    private UserAccount userMain;

    @ManyToOne(targetEntity = UserAccount.class)
    @JoinColumn(name = "userReportedid")
    private UserAccount userReported;


}
