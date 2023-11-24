package com.example.fortlomtsp.backend.domain.model.entity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@With
@AllArgsConstructor
@Table(name="artists")
@PrimaryKeyJoinColumn(referencedColumnName = "id")
public class Artist extends UserAccount{
    @NotNull
    private Long artistfollowers;

    private String instagramLink;

    private String facebookLink;

    private String twitterLink;

    private String aboutMe;

    @OneToMany(targetEntity = Tag.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "artistid",referencedColumnName = "id")
    private List<Tag> tags;

    @OneToMany(targetEntity = Album.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "artistid",referencedColumnName = "id")
    private List<Album> albums;

    @OneToMany(targetEntity = Content.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "artistid",referencedColumnName = "id")
    private List<Content> contents;
}
