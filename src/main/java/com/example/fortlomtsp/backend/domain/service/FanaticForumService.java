package com.example.fortlomtsp.backend.domain.service;

import com.example.fortlomtsp.backend.domain.model.entity.Forum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface FanaticForumService {
    List<Forum> getAllForums();
    Page<Forum> getAllForums(Pageable pageable);
    Forum getForumById(Long ForumId);
    Forum createFanaticForum(Long Fanatic, Forum forum);
    Forum updateRules(Long ForumId,String rules);
    List<Forum> getForumsByFanaticId(Long FanaticId);
    ResponseEntity<?> delete(Long ForumId);



}
