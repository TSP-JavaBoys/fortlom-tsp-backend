package com.example.fortlomtsp.backend.domain.service;
import com.example.fortlomtsp.backend.domain.model.entity.Opinion;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import java.util.List;
public interface OpinionService {
    List<Opinion> getAll();
    Page<Opinion> getAll(Pageable pageable);
    Opinion getById(Long commentId);
    ResponseEntity<?> delete(Long commentId);
    Opinion create(Long Userid,Long contentid,Opinion request);
    Opinion update(Long commentId,boolean agree);
    List<Opinion> getUserid(Long Userid);
    List<Opinion>getContentid(Long contentid);
    List<Opinion>getByAgree(boolean agree);
    List<Opinion>getByContentidAndAgree(Long contentid,boolean agree);
    List<Opinion>findByUseridAndContentid(Long Userid,Long contentid);
    boolean existsByContentidAndUserid(Long contentid,Long Userid);
}
