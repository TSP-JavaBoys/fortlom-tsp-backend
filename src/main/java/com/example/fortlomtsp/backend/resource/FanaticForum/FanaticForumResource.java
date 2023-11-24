package com.example.fortlomtsp.backend.resource.FanaticForum;


import com.example.fortlomtsp.backend.domain.model.entity.UserAccount;
import com.example.fortlomtsp.backend.resource.useraccoount.UserAccountResource;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FanaticForumResource {
    private Long id;
    private String forumname;
    private String forumdescription;
    private String forumrules;
    private UserAccountResource userAccount;


}
