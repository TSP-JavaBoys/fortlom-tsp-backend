package com.example.fortlomtsp.backend.domain.persistence;
import com.example.fortlomtsp.backend.domain.model.entity.Follow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FollowRepository extends JpaRepository<Follow,Long>{

    List<Follow> findByArtistId(Long artistid);
    List<Follow> findByFanaticId(Long fanaticId);
    boolean existsByArtistIdAndAgree(Long artistid,boolean fanaticId);
    boolean existsByArtistIdAndFanaticId(Long artistid,Long fanaticId);
    List<Follow>findByArtistIdAndFanaticId(Long artistid,Long fanaticId);
    List<Follow> findByArtistIdAndAgree(Long artistid,boolean fanaticId);
}
