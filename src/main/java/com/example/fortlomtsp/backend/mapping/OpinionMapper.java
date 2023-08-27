package com.example.fortlomtsp.backend.mapping;


import com.example.fortlomtsp.backend.domain.model.entity.Opinion;
import com.example.fortlomtsp.backend.resource.Opinion.CreateOpinionResource;
import com.example.fortlomtsp.backend.resource.Opinion.OpinionResource;
import com.example.fortlomtsp.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import java.util.List;


public class OpinionMapper {

    @Autowired
    EnhancedModelMapper mapper;



    public OpinionResource toResource(Opinion model) {
        return mapper.map(model, OpinionResource.class);
    }

    public Page<OpinionResource> modelListToPage(List<Opinion> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, OpinionResource.class), pageable, modelList.size());
    }
    public Opinion toModel(CreateOpinionResource resource) {
        return mapper.map(resource, Opinion.class);
    }

}
