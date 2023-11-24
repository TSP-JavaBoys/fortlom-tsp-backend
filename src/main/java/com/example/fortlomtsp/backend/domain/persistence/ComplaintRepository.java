package com.example.fortlomtsp.backend.domain.persistence;

import com.example.fortlomtsp.backend.domain.model.entity.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ComplaintRepository extends JpaRepository<Complaint,Long> {

    List<Complaint>findByUserMainId(Long id);
    List<Complaint>findByUserReportedId(Long id);
    List<Complaint>findByForumId(Long id);
    List<Complaint>findByPublicationId(Long id);
    List<Complaint>findByCommentId(Long id);


}
