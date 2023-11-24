package com.example.fortlomtsp.backend.domain.model.entity;
import javax.persistence.PrimaryKeyJoinColumn;
import lombok.*;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
@NoArgsConstructor
@Getter
@Setter
@Entity
@With
@AllArgsConstructor
@Table(name="publications")
@PrimaryKeyJoinColumn(referencedColumnName = "id")
public class Publication extends Content{
    private Boolean image;

    @OneToMany(targetEntity = Image.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "publicationid",referencedColumnName = "id")
    private List<Image> images;

    @OneToMany(targetEntity = PublicationComment.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "publicationid",referencedColumnName = "id")
    private List<PublicationComment> publicationComments;

    @OneToMany(targetEntity = Complaint.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "publicationid",referencedColumnName = "id")
    private List<Complaint> complaints;
}
