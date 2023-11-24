package com.example.fortlomtsp.backend.domain.persistence;

import com.example.fortlomtsp.backend.domain.model.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {
}
