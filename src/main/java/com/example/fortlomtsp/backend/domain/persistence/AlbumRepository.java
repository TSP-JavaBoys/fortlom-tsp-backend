package com.example.fortlomtsp.backend.domain.persistence;

import com.example.fortlomtsp.backend.domain.model.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {
    List<Album> findAlbumsByUserAccountId(Long userId);
    Album findAlbumByUserAccountId(Long userId);
    Album findAlbumByName(String name);
    boolean existsById(Long userId);
    Boolean existsByName(String username);
}
