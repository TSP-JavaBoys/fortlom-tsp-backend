package com.example.fortlomtsp.backend.domain.model.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;


@NoArgsConstructor
@Getter
@Setter
@Entity
@With
@AllArgsConstructor
@Table(name="comments")
@PrimaryKeyJoinColumn(referencedColumnName = "id")
@Inheritance(strategy = InheritanceType.JOINED)
public class Comment extends Answer {

    @NotNull
    @NotBlank
    @Size(max = 150)
    private String commentdescription;

    @OneToMany(targetEntity = Complaint.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "commentid",referencedColumnName = "id")
    private List<Complaint> complaints;

}
