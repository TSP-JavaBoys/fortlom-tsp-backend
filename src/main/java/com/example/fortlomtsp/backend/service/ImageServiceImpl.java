package com.example.fortlomtsp.backend.service;

import com.example.fortlomtsp.backend.domain.model.entity.Image;
import com.example.fortlomtsp.backend.domain.persistence.ImageRepository;
import com.example.fortlomtsp.backend.domain.persistence.PublicationRepository;
import com.example.fortlomtsp.backend.domain.persistence.UserAccounRepository;
import com.example.fortlomtsp.backend.domain.service.ImageService;

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
public class ImageServiceImpl implements ImageService {


    private static final String ENTITY = "Image";
    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private UserAccounRepository userAccounRepository;

    @Autowired
    private PublicationRepository publicationRepository;

    @Override
    public List<Image> getAll() {
        return imageRepository.findAll();
    }

    @Override
    public Page<Image> getAll(Pageable pageable) {
        return imageRepository.findAll(pageable);
    }

    @Override
    public Image getById(Long ImageID) {
        return imageRepository.findById(ImageID)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, ImageID));
    }

    @Override
    public Image createforuser(Long userId, Image request) {

        return userAccounRepository.findById(userId)
                .map(users -> {
                    request.setUserAccount(users);

                    return imageRepository.save(request);
                })
                .orElseThrow(() -> new ResourceNotFoundException("User", userId));

    }

    @Override
    public Image createforpublication(Long publicationId, Image request) {
        return publicationRepository.findById(publicationId)
                .map(publication -> {
                    request.setPublication(publication);

                    return imageRepository.save(request);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Publication", publicationId));



    }

    @Override
    public List<Image> getImageByUserId(Long userId) {
        return imageRepository.findByUserAccountId(userId);
    }

    @Override
    public List<Image> getImageByPublicationId(Long PublicationId) {
        return imageRepository.findByPublicationId(PublicationId);
    }

    @Override
    public ResponseEntity<?> delete(Long PublicationId) {
        return imageRepository.findById(PublicationId).map(Publication -> {
            imageRepository.delete(Publication);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, PublicationId));
    }

    @Override
    public boolean exists(Long id) {
        return imageRepository.existsById(id);
    }
}
