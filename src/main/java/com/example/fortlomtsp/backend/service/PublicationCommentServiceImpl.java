package com.example.fortlomtsp.backend.service;


import com.example.fortlomtsp.backend.domain.model.entity.PublicationComment;
import com.example.fortlomtsp.backend.domain.model.entity.UserAccount;
import com.example.fortlomtsp.backend.domain.persistence.PublicationCommentRepository;
import com.example.fortlomtsp.backend.domain.persistence.PublicationRepository;
import com.example.fortlomtsp.backend.domain.persistence.UserAccounRepository;
import com.example.fortlomtsp.backend.domain.service.PublicationCommentService;
import com.example.fortlomtsp.shared.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicationCommentServiceImpl implements PublicationCommentService {
    private static final String ENTITY = "PublicationComment";

    @Autowired
    private PublicationCommentRepository publicationCommentRepository;

    @Autowired
    private UserAccounRepository userAccounRepository;

    @Autowired
    private PublicationRepository publicationRepository;

    @Override
    public List<PublicationComment> getAll() {
        return publicationCommentRepository.findAll();

    }

    @Override
    public Page<PublicationComment> getAll(Pageable pageable) {
        return publicationCommentRepository.findAll(pageable);

    }

    @Override
    public PublicationComment getById(Long commentId) {
        return  publicationCommentRepository.findById(commentId).orElseThrow(() -> new ResourceNotFoundException(ENTITY, commentId));

    }

    @Override
    public PublicationComment create(Long userId, Long publicationId, PublicationComment request) {

        UserAccount userAccount = userAccounRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", userId));
        return publicationRepository.findById(publicationId)
                .map(artist -> {
                    request.setPublication(artist);
                    request.setUserAccount(userAccount);
                    return publicationCommentRepository.save(request);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Publication", publicationId));


    }

    @Override
    public List<PublicationComment> getCommentByPublicationId(Long publicationId) {

            return publicationCommentRepository.findByPublicationId(publicationId);

    }

    @Override
    public ResponseEntity<?> delete(Long commentId) {
        return publicationCommentRepository.findById(commentId).map(Publication -> {
            publicationCommentRepository.delete(Publication);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, commentId));
    }
}
