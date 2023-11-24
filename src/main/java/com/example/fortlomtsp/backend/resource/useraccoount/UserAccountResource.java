package com.example.fortlomtsp.backend.resource.useraccoount;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserAccountResource {

    private Long id;

    private String username;

    private String realname;

    private String lastname;

    private String email;

    private String password;
}
