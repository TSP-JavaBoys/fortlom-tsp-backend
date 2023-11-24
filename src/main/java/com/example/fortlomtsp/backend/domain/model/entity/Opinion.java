package com.example.fortlomtsp.backend.domain.model.entity;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;


@NoArgsConstructor
@Getter
@Setter
@Entity
@With
@AllArgsConstructor
@Table(name="opinions")
@PrimaryKeyJoinColumn(referencedColumnName = "id")
public class Opinion extends Answer {

    private boolean agree;

    @ManyToOne(targetEntity = Content.class)
    @JoinColumn(name = "contentid")
    private Content content;


}
