package com.example.fortlomtsp.backend.domain.persistence;

import com.example.fortlomtsp.backend.domain.model.entity.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentRepository extends JpaRepository<Content,Long> {
}
