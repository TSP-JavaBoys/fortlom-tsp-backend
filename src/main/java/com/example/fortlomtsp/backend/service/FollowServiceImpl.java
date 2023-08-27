package com.example.fortlomtsp.backend.service;



import com.example.fortlomtsp.backend.domain.model.entity.Fanatic;
import com.example.fortlomtsp.backend.domain.model.entity.Follow;
import com.example.fortlomtsp.backend.domain.persistence.ArtistRepository;
import com.example.fortlomtsp.backend.domain.persistence.FanaticRepository;
import com.example.fortlomtsp.backend.domain.persistence.FollowRepository;
import com.example.fortlomtsp.backend.domain.service.FollowService;
import com.example.fortlomtsp.shared.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FollowServiceImpl implements FollowService {


    private static final String ENTITY = "Follow";


    @Autowired
    private FollowRepository followRepository;

    @Autowired
    private FanaticRepository fanaticRepository;

    @Autowired
    private ArtistRepository artistRepository;

    @Override
    public List<Follow> getAllForums() {
        return followRepository.findAll();
    }

    @Override
    public Page<Follow> getAllForums(Pageable pageable) {
        return followRepository.findAll(pageable);
    }

    @Override
    public Follow getFollowById(Long FollowId) {

        return followRepository.findById(FollowId).orElseThrow(() -> new ResourceNotFoundException(ENTITY, FollowId));
    }

    @Override
    public Follow createFollow(Long fanaticId,Long artistId,boolean boolfollow) {
        Follow follow = new Follow();
        Fanatic fanatic = fanaticRepository.findById(fanaticId)
                .orElseThrow(() -> new ResourceNotFoundException("Fanatic", fanaticId));
        return artistRepository.findById(artistId)
                .map(artists -> {
                    follow.setArtist(artists);
                    follow.setFanatic(fanatic);
                    follow.setAgree(boolfollow);
                    return followRepository.save(follow);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Artist", artistId));


    }

    @Override
    public Follow update(Long followid, boolean boolfollow) {
        return followRepository.findById(followid).map(opinion -> {
            opinion.setAgree(boolfollow);
            followRepository.save(opinion);
            return opinion;
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, followid));
    }

    @Override
    public List<Follow> getFollowByartistId(Long artistId) {
        return followRepository.findByArtistId(artistId);
    }

    @Override
    public ResponseEntity<?> delete(Long followId) {

        return followRepository.findById(followId).map(Forum -> {
            followRepository.delete(Forum);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, followId));
    }

    @Override
    public boolean existsByArtistidAndAgree(Long artistoid, boolean fanaticId) {
        return followRepository.existsByArtistIdAndAgree(artistoid,fanaticId);
    }

    @Override
    public boolean existsByArtistidAndFanaticid(Long artistid, Long fanaticId) {
        return followRepository.existsByArtistIdAndFanaticId(artistid,fanaticId);
    }

    @Override
    public List<Follow> getByArtistidAndAgree(Long artistId, boolean fanaticId) {
        return followRepository.findByArtistIdAndAgree(artistId,fanaticId);
    }

    @Override
    public List<Follow> findByArtistidAndFanaticid(Long artistid, Long fanaticId) {
        return followRepository.findByArtistIdAndFanaticId( artistid,  fanaticId);
    }
}
