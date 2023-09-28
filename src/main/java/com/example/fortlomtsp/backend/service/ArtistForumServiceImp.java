package com.example.fortlomtsp.backend.service;

import com.example.fortlomtsp.backend.domain.model.entity.Forum;
import com.example.fortlomtsp.backend.domain.persistence.ArtistRepository;
import com.example.fortlomtsp.backend.domain.persistence.ForumRepository;
import com.example.fortlomtsp.backend.domain.service.ArtistForumService;
import com.example.fortlomtsp.shared.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistForumServiceImp implements ArtistForumService {

    private final ForumRepository forumRepository;
    private final ArtistRepository artistRepository;

    public ArtistForumServiceImp(ForumRepository forumRepository, ArtistRepository artistRepository) {
        this.forumRepository = forumRepository;
        this.artistRepository = artistRepository;
    }

    @Override
    public Forum create(Long Artist, Forum forum) {
        return artistRepository.findById(Artist).map(artist -> {
                    forum.setUserAccount(artist);
                    return forumRepository.save(forum);
                }

        ).orElseThrow(() -> new ResourceNotFoundException("Artist", Artist));
    }

    @Override
    public List<Forum> getByArtistId(Long ArtistId) {
        return forumRepository.findByUserAccountId(ArtistId);
    }
}
