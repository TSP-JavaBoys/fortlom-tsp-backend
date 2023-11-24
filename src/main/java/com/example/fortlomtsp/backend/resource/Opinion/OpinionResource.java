package com.example.fortlomtsp.backend.resource.Opinion;


import com.example.fortlomtsp.backend.resource.useraccoount.UserAccountResource;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class OpinionResource {
    private Long id;

    private Date registerdate;

    private UserAccountResource user;
    private ContentResource content;

    private boolean agree;



}
