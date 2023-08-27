package com.example.fortlomtsp.backend.mapping;

import com.example.fortlomtsp.backend.domain.model.entity.Follow;
import com.example.fortlomtsp.backend.resource.Follow.FollowResource;
import com.example.fortlomtsp.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;
public class FollowMapper {

    @Autowired
    EnhancedModelMapper mapper;



    public FollowResource toResource(Follow model) {
        return mapper.map(model, FollowResource.class);
    }

    public Page<FollowResource> modelListToPage(List<Follow> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, FollowResource.class), pageable, modelList.size());
    }
}
