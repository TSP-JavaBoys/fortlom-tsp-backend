package com.example.fortlomtsp.backend.service;

import com.example.fortlomtsp.backend.domain.model.entity.Forum;
import com.example.fortlomtsp.backend.domain.persistence.FanaticRepository;
import com.example.fortlomtsp.backend.domain.persistence.ForumRepository;
import com.example.fortlomtsp.backend.domain.service.FanaticForumService;
import com.example.fortlomtsp.shared.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FanaticForumServiceImpl implements FanaticForumService {

    private static final String ENTITY = "Forum";
    @Autowired
    private ForumRepository forumRepository;

    @Autowired
    private FanaticRepository fanaticRepository;


    @Override
    public List<Forum> getAllForums() {
        return forumRepository.findAll();
    }

    @Override
    public Page<Forum> getAllForums(Pageable pageable) {
        return forumRepository.findAll(pageable);
    }

    @Override
    public Forum getForumById(Long ForumId) {
        return forumRepository.findById(ForumId).orElseThrow(() -> new ResourceNotFoundException(ENTITY, ForumId));
    }

    @Override
    public Forum createFanaticForum(Long Fanatic, Forum forum) {

        return fanaticRepository.findById(Fanatic).map(fanatic -> {
                    forum.setUserAccount(fanatic);
                    return forumRepository.save(forum);
                }

        ).orElseThrow(() -> new ResourceNotFoundException("Fanatic", Fanatic));

    }

    @Override
    public Forum updateRules(Long ForumId, String rules) {
        return forumRepository.findById(ForumId).map(forum -> {
                forum.setForumrules(rules);
                forumRepository.save(forum);
                return forum;
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, ForumId));
    }

    @Override
    public List<Forum> getForumsByFanaticId(Long FanaticId) {
        return forumRepository.findByUserAccountId(FanaticId);
    }

    @Override
    public ResponseEntity<?> delete(Long ForumId) {
        return forumRepository.findById(ForumId).map(forum -> {
            forumRepository.delete(forum);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, ForumId));
    }
}
