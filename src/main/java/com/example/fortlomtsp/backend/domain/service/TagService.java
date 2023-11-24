package com.example.fortlomtsp.backend.domain.service;

import com.example.fortlomtsp.backend.domain.model.entity.Tag;

import java.util.List;

public interface TagService {
    List<Tag> getTagsByArtistId(Long artistId);
    Tag createTag(Long Artist, Tag event);
}
