package com.example.fortlomtsp.backend.domain.persistence;
import com.example.fortlomtsp.backend.domain.model.entity.Forum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ForumRepository extends JpaRepository<Forum,Long>{

    List<Forum> findByUserAccountId(Long userId);
    boolean existsById(Long userId);
}
