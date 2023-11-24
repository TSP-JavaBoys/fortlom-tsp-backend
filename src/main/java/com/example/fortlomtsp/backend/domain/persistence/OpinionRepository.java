package com.example.fortlomtsp.backend.domain.persistence;


import com.example.fortlomtsp.backend.domain.model.entity.Opinion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OpinionRepository extends JpaRepository<Opinion,Long>{

    List<Opinion> findByUserAccountId(Long Userid);
    List<Opinion>findByContentId(Long contentid);
    List<Opinion>findByAgree(boolean agree);
    List<Opinion>findByContentIdAndAgree(Long contentid,boolean agree);
    List<Opinion>findByUserAccountIdAndContentId(Long Userid,Long contentid);
    boolean existsByContentIdAndUserAccountId(Long contentid,Long Userid);
}
