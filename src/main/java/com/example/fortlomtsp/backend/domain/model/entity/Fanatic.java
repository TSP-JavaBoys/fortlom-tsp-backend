package com.example.fortlomtsp.backend.domain.model.entity;
import lombok.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.*;
@NoArgsConstructor
@Getter
@Setter
@Entity
@With
@AllArgsConstructor
@Table(name="fanatics")
@PrimaryKeyJoinColumn(referencedColumnName = "id")
public class Fanatic extends UserAccount{
    @NotNull
    @NotBlank
    @Size(max = 30)
    @Column(unique = true)
    private String fanaticalias;
}
