package com.example.fortlomtsp.backend.domain.service;

import com.example.fortlomtsp.backend.domain.model.entity.Follow;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import java.util.List;


public interface FollowService {

    List<Follow> getAllForums();
    Page<Follow> getAllForums(Pageable pageable);
    Follow getFollowById(Long FollowId);
    Follow createFollow(Long fanaticId,Long artistId,boolean boolfollow);
    Follow update(Long followid,boolean boolfollow);
    List<Follow> getFollowByartistId(Long artistId);
    ResponseEntity<?> delete(Long followId);
    boolean existsByArtistidAndAgree(Long artistid,boolean fanaticId);
    boolean existsByArtistidAndFanaticid(Long artistid,Long fanaticId);
    List<Follow> getByArtistidAndAgree(Long artistid,boolean fanaticId);
    List<Follow>findByArtistidAndFanaticid(Long artistid,Long fanaticId);
}
