package com.example.fortlomtsp.backend.resource.admin;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class AdminResource {
    private Long id;


    private String username;



    private String password;
}
