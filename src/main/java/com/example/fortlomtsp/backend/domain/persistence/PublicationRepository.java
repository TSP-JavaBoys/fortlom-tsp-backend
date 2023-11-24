package com.example.fortlomtsp.backend.domain.persistence;
import com.example.fortlomtsp.backend.domain.model.entity.Publication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublicationRepository extends JpaRepository<Publication,Long>{
    List<Publication> findByArtistId(Long artistId);

    boolean existsById(Long publicationId);
}
