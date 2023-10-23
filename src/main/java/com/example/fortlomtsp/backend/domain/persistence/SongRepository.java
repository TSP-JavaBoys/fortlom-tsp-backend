package com.example.fortlomtsp.backend.domain.persistence;

import com.example.fortlomtsp.backend.domain.model.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {
    List<Song> findByAlbumId(Long albumId);
    Song findSongByName(String name);
    boolean existsById(Long userId);
    Boolean existsByName(String name);
    Boolean existsByMusicUrl(String musicUrl);
}
