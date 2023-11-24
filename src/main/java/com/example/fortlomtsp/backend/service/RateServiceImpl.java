package com.example.fortlomtsp.backend.service;


import com.example.fortlomtsp.backend.domain.model.entity.Fanatic;
import com.example.fortlomtsp.backend.domain.model.entity.Rate;
import com.example.fortlomtsp.backend.domain.persistence.ArtistRepository;
import com.example.fortlomtsp.backend.domain.persistence.FanaticRepository;
import com.example.fortlomtsp.backend.domain.persistence.RateRepository;
import com.example.fortlomtsp.backend.domain.service.RateService;
import com.example.fortlomtsp.shared.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Service
public class RateServiceImpl implements RateService {


    private static final String ENTITY = "Follow";

    @Autowired
    private RateRepository rateRepository;

    @Autowired
    private FanaticRepository fanaticRepository;

    @Autowired
    private ArtistRepository artistRepository;

    @Override
    public List<Rate> getAllRates() {
        return rateRepository.findAll();
    }

    @Override
    public Page<Rate> getAllRates(Pageable pageable) {
        return rateRepository.findAll(pageable);
    }

    @Override
    public Rate getRateById(Long rateId) {
        return rateRepository.findById(rateId).orElseThrow(() -> new ResourceNotFoundException(ENTITY, rateId));
    }

    @Override
    public Rate createRate(Long artistId,Long fanaticId, Rate request) {

        Fanatic faan = fanaticRepository.findById(fanaticId)
                .orElseThrow(() -> new ResourceNotFoundException("Fanatic", fanaticId));
        return artistRepository.findById(artistId)
                .map(artist -> {
                    request.setArtist(artist);
                    request.setFanatic(faan);
                    return rateRepository.save(request);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Artist", artistId));

    }

    @Override
    public List<Rate> getRateByartistId(Long artistId) {
        return rateRepository.findByArtistId(artistId);
    }

    @Override
    public List<Rate> getRateByfanaticId(Long fanaticId) {
        return rateRepository.findByFanaticId(fanaticId);
    }

    @Override
    public ResponseEntity<?> delete(Long rateId) {
        return rateRepository.findById(rateId).map(Forum -> {
            rateRepository.delete(Forum);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, rateId));
    }

    @Override
    public boolean existsByArtistidAndFanaticid(Long artistid, Long fanaticId) {
        return rateRepository.existsByArtistIdAndFanaticId(artistid,fanaticId);
    }

    @Override
    public Rate update(Long rateId, Rate review) {
        return rateRepository.findById(rateId).map(opinion -> {
            opinion.setReview(review.getReview());
            rateRepository.save(opinion);
            return opinion;
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, rateId));
    }

    @Override
    public List<Rate> findByArtistidAndFanaticid(Long artistid, Long fanaticId) {
        return rateRepository.findByArtistIdAndFanaticId(artistid,fanaticId);
    }
}
