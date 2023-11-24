package com.example.fortlomtsp.backend.domain.service;

import com.example.fortlomtsp.backend.domain.model.entity.Complaint;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import java.util.List;
public interface ComplaintService {
    List<Complaint> getAll();
    Page<Complaint> getAll(Pageable pageable);
    Complaint getById(Long reportId);
    Complaint createforpublication(Long UserMainId, Long UserReportedId,Long PublicationId ,Complaint complaint);
    Complaint createforcomment(Long UserMainId, Long UserReportedId,Long CommentId ,Complaint complaint);
    Complaint createforforumt(Long UserMainId, Long UserReportedId,Long ForumId ,Complaint complaint);
    List<Complaint> findByUserMainId(Long UserMainId);
    List<Complaint> findByUserReportedId(Long UserReportedId);
    List<Complaint> findByPublicationId(Long UserReportedId);
    List<Complaint> findByforumId(Long UserReportedId);
    List<Complaint> findBycommentId(Long UserReportedId);
    ResponseEntity<?> delete(Long rateId);
}
