package com.example.fortlomtsp.backend.domain.persistence;




import com.example.fortlomtsp.backend.domain.model.entity.Rate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RateRepository extends JpaRepository<Rate,Long> {
    List<Rate> findByArtistId(Long artistid);
    List<Rate> findByFanaticId(Long fanaticId);
    boolean existsByArtistIdAndFanaticId(Long artistid,Long fanaticId);
    List<Rate> findByArtistIdAndReview(Long artistid,Float review);
    List<Rate> findByArtistIdAndFanaticId(Long artistid,Long fanaticId);

}
