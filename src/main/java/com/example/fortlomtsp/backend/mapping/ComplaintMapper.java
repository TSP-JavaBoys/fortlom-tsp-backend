package com.example.fortlomtsp.backend.mapping;

import com.example.fortlomtsp.backend.domain.model.entity.Complaint;
import com.example.fortlomtsp.backend.resource.complaint.ComplaintResource;
import com.example.fortlomtsp.backend.resource.complaint.CreateComplaintResource;
import com.example.fortlomtsp.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import java.util.List;
public class ComplaintMapper {

    @Autowired
    EnhancedModelMapper mapper;



    public ComplaintResource toResource(Complaint model) {
        return mapper.map(model, ComplaintResource.class);
    }

    public Page<ComplaintResource> modelListToPage(List<Complaint> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, ComplaintResource.class), pageable, modelList.size());
    }
    public Complaint toModel(CreateComplaintResource resource) {
        return mapper.map(resource, Complaint.class);
    }
}
