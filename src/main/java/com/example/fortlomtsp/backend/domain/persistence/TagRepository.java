package com.example.fortlomtsp.backend.domain.persistence;


import com.example.fortlomtsp.backend.domain.model.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepository extends JpaRepository<Tag,Long>{
    List<Tag> findByArtistId(Long artistId);
    Boolean existsByName(String name);
}
