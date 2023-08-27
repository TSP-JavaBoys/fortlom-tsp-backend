package com.example.fortlomtsp.backend.service;

import com.example.fortlomtsp.backend.domain.model.entity.Publication;
import com.example.fortlomtsp.backend.domain.persistence.ArtistRepository;
import com.example.fortlomtsp.backend.domain.persistence.PublicationRepository;
import com.example.fortlomtsp.backend.domain.service.PublicationService;
import com.example.fortlomtsp.shared.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.validation.Validator;
import java.util.Date;
import java.util.List;


@Service
public class PublicationServiceImpl implements PublicationService {

    private static final String ENTITY = "Publication";
    private static final String ENTITY2 = "Artist";

    @Autowired
    private PublicationRepository publicationRepository;
    @Autowired
    private ArtistRepository artistRepository;

    @Override
    public List<Publication> getAll() {


        return publicationRepository.findAll();



    }

    @Override
    public Page<Publication> getAll(Pageable pageable) {


        return publicationRepository.findAll(pageable);



    }

    @Override
    public Publication getById(Long publicationId) {

        return publicationRepository.findById(publicationId).orElseThrow(() -> new ResourceNotFoundException(ENTITY, publicationId));

    }

    @Override
    public Publication create(Long artistId, Publication request, String type) {

        return artistRepository.findById(artistId)
                .map(artists -> {
                    if(type.equals("true")){
                        request.setImage(true);
                    }else {
                        request.setImage(false);
                    }
                    request.setArtist(artists);
                    Date date = new Date();
                    request.setRegisterdate(date);
                    return publicationRepository.save(request);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Artist", artistId));
    }

    @Override
    public Publication update(Long publicationId, Publication request) {
        return publicationRepository.findById(publicationId).map(post->{


            publicationRepository.save(post);
            return post;

        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, publicationId));
    }

    @Override
    public List<Publication> getPublicationByArtistId(Long artistId) {

            return publicationRepository.findByArtistId(artistId);

    }

    @Override
    public ResponseEntity<?> delete(Long publicationId) {
        return publicationRepository.findById(publicationId).map(post -> {
            publicationRepository.delete(post);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, publicationId));
    }


    @Override
    public boolean existspublication(Long publicationId) {
        return publicationRepository.existsById(publicationId);
    }
}
