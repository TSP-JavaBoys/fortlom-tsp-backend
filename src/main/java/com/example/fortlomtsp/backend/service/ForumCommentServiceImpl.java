package com.example.fortlomtsp.backend.service;

import com.example.fortlomtsp.backend.domain.model.entity.Fanatic;
import com.example.fortlomtsp.backend.domain.model.entity.ForumComment;
import com.example.fortlomtsp.backend.domain.model.entity.UserAccount;
import com.example.fortlomtsp.backend.domain.persistence.ForumCommentRepository;
import com.example.fortlomtsp.backend.domain.persistence.ForumRepository;
import com.example.fortlomtsp.backend.domain.persistence.UserAccounRepository;
import com.example.fortlomtsp.backend.domain.service.ForumCommentService;
import com.example.fortlomtsp.shared.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;

@Service
public class ForumCommentServiceImpl implements ForumCommentService {

    private static final String ENTITY = "ForumComment";

    @Autowired
    private ForumCommentRepository forumcommentRepository;

    @Autowired
    private UserAccounRepository userAccounRepository;

    @Autowired
    private ForumRepository forumRepository;
    @Override
    public List<ForumComment> getAll() {
        return forumcommentRepository.findAll();

    }

    @Override
    public Page<ForumComment> getAll(Pageable pageable) {
        return forumcommentRepository.findAll(pageable);

    }

    @Override
    public ForumComment getById(Long forumcommentId) {
        return forumcommentRepository.findById(forumcommentId).orElseThrow(() -> new ResourceNotFoundException(ENTITY, forumcommentId));

    }

    @Override
    public ForumComment create(Long userId, Long forumId, ForumComment request) {

        UserAccount userAccount = userAccounRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", userId));
        return forumRepository.findById(forumId)
                .map(artist -> {
                    request.setForum(artist);
                    request.setUserAccount(userAccount);
                    return forumcommentRepository.save(request);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Forum", forumId));
    }

    @Override
    public List<ForumComment> getForumCommentByForumId(Long forumId) {

            return forumcommentRepository.findByForumId(forumId);


    }

    @Override
    public ResponseEntity<?> delete(Long forumcommentId) {
        return forumcommentRepository.findById(forumcommentId).map(Forum -> {
            forumcommentRepository.delete(Forum);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, forumcommentId));
    }
}
