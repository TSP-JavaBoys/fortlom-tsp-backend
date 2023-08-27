package com.example.fortlomtsp.backend.service;

import com.example.fortlomtsp.backend.domain.model.entity.Tag;
import com.example.fortlomtsp.backend.domain.persistence.ArtistRepository;
import com.example.fortlomtsp.backend.domain.persistence.TagRepository;
import com.example.fortlomtsp.backend.domain.service.TagService;

import com.example.fortlomtsp.shared.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.Validator;
import java.util.List;

@Service
public class TagServiceImpl implements TagService {
    private static final String ENTITY = "Tag";
    private static final String ENTITY2 = "Artist";
    @Autowired
    private TagRepository tagRepository;
    @Autowired
    private ArtistRepository artistRepository;
    @Override
    public List<Tag> getTagsByArtistId(Long artistId) {
        return tagRepository.findByArtistId(artistId);
    }

    @Override
    public Tag createTag(Long Artist, Tag request) {
        return artistRepository.findById(Artist)
                .map(artists -> {
                    request.setArtist(artists);
                    return tagRepository.save(request);
                })
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY2, Artist));
    }



}
