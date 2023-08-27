package com.example.fortlomtsp.backend.service;


import com.example.fortlomtsp.backend.domain.model.entity.Opinion;
import com.example.fortlomtsp.backend.domain.model.entity.UserAccount;
import com.example.fortlomtsp.backend.domain.persistence.ContentRepository;
import com.example.fortlomtsp.backend.domain.persistence.OpinionRepository;
import com.example.fortlomtsp.backend.domain.persistence.UserAccounRepository;
import com.example.fortlomtsp.backend.domain.service.OpinionService;
import com.example.fortlomtsp.shared.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Service
public class OpinionServiceImpl implements OpinionService {


    private static final String ENTITY = "Opinion";

    @Autowired
    private OpinionRepository opinionRepository;

    @Autowired
    private UserAccounRepository userAccounRepository;

    @Autowired
    private ContentRepository contentRepository;
    @Override
    public List<Opinion> getAll() {
        return opinionRepository.findAll();
    }

    @Override
    public Page<Opinion> getAll(Pageable pageable) {
        return opinionRepository.findAll(pageable);
    }

    @Override
    public Opinion getById(Long commentId) {
        return opinionRepository.findById(commentId).orElseThrow(() -> new ResourceNotFoundException(ENTITY, commentId));
    }

    @Override
    public ResponseEntity<?> delete(Long commentId) {
        return opinionRepository.findById(commentId).map(opinion -> {
            opinionRepository.delete(opinion);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, commentId));
    }

    @Override
    public Opinion create(Long Userid, Long contentid,Opinion request) {

        UserAccount userAccount = userAccounRepository.findById(Userid)
                .orElseThrow(() -> new ResourceNotFoundException("User", Userid));
        return contentRepository.findById(contentid)
                .map(content -> {
                    request.setContent(content);
                    request.setUserAccount(userAccount);
                    return opinionRepository.save(request);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Publication", contentid));

    }

    @Override
    public Opinion update(Long commentId, boolean agree) {
        return opinionRepository.findById(commentId).map(opinion -> {
              opinion.setAgree(agree);
              opinionRepository.save(opinion);
              return opinion;
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, commentId));
    }

    @Override
    public List<Opinion> getUserid(Long Userid) {


            return opinionRepository.findByUserAccountId(Userid);

    }

    @Override
    public List<Opinion> getContentid(Long contentid) {


            return opinionRepository.findByContentId(contentid);

    }

    @Override
    public List<Opinion> getByAgree(boolean agree) {
        return opinionRepository.findByAgree(agree);
    }

    @Override
    public List<Opinion> getByContentidAndAgree(Long contentid, boolean agree) {
        return opinionRepository.findByContentIdAndAgree(contentid,agree);
    }

    @Override
    public List<Opinion> findByUseridAndContentid(Long Userid, Long contentid) {
        return opinionRepository.findByUserAccountIdAndContentId(Userid,contentid);
    }

    @Override
    public boolean existsByContentidAndUserid(Long contentid, Long Userid) {
        return opinionRepository.existsByContentIdAndUserAccountId(contentid,Userid);
    }
}
