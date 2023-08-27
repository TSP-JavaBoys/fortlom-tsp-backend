package com.example.fortlomtsp.backend.domain.service;

import com.example.fortlomtsp.backend.domain.model.entity.Publication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PublicationService {
    List<Publication> getAll();
    Page<Publication> getAll(Pageable pageable);
    Publication getById(Long publicationId);
    Publication create(Long artistId, Publication publication,String type);
    Publication update(Long publicationId, Publication request);
    List<Publication> getPublicationByArtistId(Long artistId);
    ResponseEntity<?> delete(Long publicationId);
    boolean existspublication(Long publicationId);
}
