package com.example.fortlomtsp.backend.domain.service;

import com.example.fortlomtsp.backend.domain.model.entity.Forum;

import java.util.List;

public interface ArtistForumService {
    Forum create(Long Fanatic, Forum forum);
    List<Forum> getByArtistId(Long FanaticId);
}
