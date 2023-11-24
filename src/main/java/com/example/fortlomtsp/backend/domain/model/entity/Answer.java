package com.example.fortlomtsp.backend.domain.model.entity;
import lombok.*;
import org.hibernate.annotations.Type;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "answers")
@Inheritance(strategy = InheritanceType.JOINED)
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date registerdate;

    @ManyToOne(targetEntity = UserAccount.class)
    @JoinColumn(name = "userid")
    private UserAccount userAccount;
}
