package com.example.fortlomtsp.backend.domain.model.entity;
import lombok.*;
import org.hibernate.annotations.Type;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "useraccounts")
@Inheritance(strategy = InheritanceType.JOINED)
public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 30)
    @Column(unique = true)
    private String username;

    @NotNull
    @NotBlank
    @Size(max = 25)
    private String realname;

    @NotNull
    @NotBlank
    @Size(max = 25)
    private String lastname;

    @NotNull
    @NotBlank
    @Size(max = 50)
    @Email
    @Column(unique = true)
    private String email;


    @NotNull
    @NotBlank
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Rol> roles=new HashSet<>();

    private String tokenpassword;


    @OneToMany(targetEntity = Image.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "userid",referencedColumnName = "id")
    private List<Image> images;

    @OneToMany(targetEntity = Forum.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "userid",referencedColumnName = "id")
    private List<Forum> forums;

    @OneToMany(targetEntity = Complaint.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "userMainid",referencedColumnName = "id")
    private List<Complaint> reportmains;

    @OneToMany(targetEntity = Complaint.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "userReportedid",referencedColumnName = "id")
    private List<Complaint> reporttouser;

    @OneToMany(targetEntity = Answer.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "userid",referencedColumnName = "id")
    private List<Answer> answers;

}
