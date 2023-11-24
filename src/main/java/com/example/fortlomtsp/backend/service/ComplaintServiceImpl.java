package com.example.fortlomtsp.backend.service;


import com.example.fortlomtsp.backend.domain.model.entity.*;
import com.example.fortlomtsp.backend.domain.persistence.*;
import com.example.fortlomtsp.backend.domain.service.ComplaintService;
import com.example.fortlomtsp.shared.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Service
public class ComplaintServiceImpl implements ComplaintService {

    private static final String ENTITY = "Complaint";

    @Autowired
    private ComplaintRepository complaintRepository;

    @Autowired
    private UserAccounRepository userAccounRepository;

    @Autowired
    private PublicationRepository publicationRepository;

    @Autowired
    private ForumRepository forumRepository;


    @Autowired
    private CommentRepository commentRepository;


    @Override
    public List<Complaint> getAll() {

        return complaintRepository.findAll();


    }

    @Override
    public Page<Complaint> getAll(Pageable pageable) {

       return complaintRepository.findAll(pageable);

    }

    @Override
    public Complaint getById(Long reportId) {
        return complaintRepository.findById(reportId).orElseThrow(() -> new ResourceNotFoundException(ENTITY, reportId));

    }

    @Override
    public Complaint createforpublication(Long UserMainId, Long UserReportedId,Long PublicationId ,Complaint request) {


        UserAccount usermain = userAccounRepository.findById(UserMainId)
                .orElseThrow(() -> new ResourceNotFoundException("User", UserMainId));
        UserAccount userreport= userAccounRepository.findById(UserReportedId)
                .orElseThrow(() -> new ResourceNotFoundException("User", UserReportedId));
        Publication publication= publicationRepository.findById(PublicationId)
                .orElseThrow(() -> new ResourceNotFoundException("Publication", PublicationId));

            request.setUserMain(usermain);
            request.setUserReported(userreport);
            request.setPublicationId(publication);
            return complaintRepository.save(request);


    }

    @Override
    public Complaint createforcomment(Long UserMainId, Long UserReportedId, Long CommentId, Complaint request) {
        UserAccount usermain = userAccounRepository.findById(UserMainId)
                .orElseThrow(() -> new ResourceNotFoundException("User", UserMainId));
        UserAccount userreport= userAccounRepository.findById(UserReportedId)
                .orElseThrow(() -> new ResourceNotFoundException("User", UserReportedId));
        Comment comment= commentRepository.findById(CommentId)
                .orElseThrow(() -> new ResourceNotFoundException("Publication", CommentId));

            request.setUserMain(usermain);
            request.setUserReported(userreport);
            request.setCommentId(comment);
            return complaintRepository.save(request);

    }

    @Override
    public Complaint createforforumt(Long UserMainId, Long UserReportedId, Long ForumId, Complaint request) {
        UserAccount usermain = userAccounRepository.findById(UserMainId)
                .orElseThrow(() -> new ResourceNotFoundException("User", UserMainId));
        UserAccount userreport= userAccounRepository.findById(UserReportedId)
                .orElseThrow(() -> new ResourceNotFoundException("User", UserReportedId));
        Forum forum= forumRepository.findById(ForumId)
                .orElseThrow(() -> new ResourceNotFoundException("Forum", ForumId));

        request.setUserMain(usermain);
        request.setUserReported(userreport);
            request.setForumId(forum);
            return complaintRepository.save(request);

    }

    @Override
    public List<Complaint> findByUserMainId(Long UserMainId) {


            return complaintRepository.findByUserMainId(UserMainId);


    }

    @Override
    public List<Complaint> findByUserReportedId(Long UserReportedId) {
        return complaintRepository.findByUserReportedId(UserReportedId);

    }

    @Override
    public List<Complaint> findByPublicationId(Long UserReportedId) {
       return complaintRepository.findByPublicationId(UserReportedId);

    }

    @Override
    public List<Complaint> findByforumId(Long UserReportedId) {
        return complaintRepository.findByForumId(UserReportedId);

    }

    @Override
    public List<Complaint> findBycommentId(Long UserReportedId) {
        return complaintRepository.findByCommentId(UserReportedId);

    }

    @Override
    public ResponseEntity<?> delete(Long rateId) {
        return complaintRepository.findById(rateId).map(Forum -> {
            complaintRepository.delete(Forum);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, rateId));
    }






}
