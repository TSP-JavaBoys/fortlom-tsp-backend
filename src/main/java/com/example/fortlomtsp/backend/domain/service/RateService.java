package com.example.fortlomtsp.backend.domain.service;

import com.example.fortlomtsp.backend.domain.model.entity.Rate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RateService {

    List<Rate> getAllRates();
    Page<Rate> getAllRates(Pageable pageable);
    Rate getRateById(Long rateId);
    Rate createRate(Long artistId,Long fanaticId,Rate Forum);
    List<Rate> getRateByartistId(Long artistId);
    List<Rate> getRateByfanaticId(Long fanaticId);
    ResponseEntity<?> delete(Long rateId);
    boolean existsByArtistidAndFanaticid(Long artistid,Long fanaticId);
    Rate update(Long rateId,Rate review);
    List<Rate> findByArtistidAndFanaticid(Long artistid,Long fanaticId);
}
