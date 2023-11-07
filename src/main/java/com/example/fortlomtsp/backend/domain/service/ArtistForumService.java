package com.example.fortlomtsp.backend.domain.service;

import com.example.fortlomtsp.backend.domain.model.entity.Forum;
import com.example.fortlomtsp.backend.domain.model.entity.Publication;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ArtistForumService {
    Forum create(Long Fanatic, Forum forum);
    List<Forum> getByArtistId(Long FanaticId);

    ResponseEntity<?> delete(Long ForumId);

    Forum update(Long ForumId, Forum request);
}
