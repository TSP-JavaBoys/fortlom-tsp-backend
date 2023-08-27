package com.example.fortlomtsp.backend.domain.model.entity;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import lombok.*;

import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@Entity

@Table(name="admins")
public class Admin extends UserAccount{
}
