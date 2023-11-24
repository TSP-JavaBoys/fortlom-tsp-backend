package com.example.fortlomtsp.backend.security.Dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class RegisterUser {
    @NotBlank
    private String username;
    private String email;
    private String password;

    private String realname;


    private String lastname;
    private Set<String> roles=new HashSet<>();
}
