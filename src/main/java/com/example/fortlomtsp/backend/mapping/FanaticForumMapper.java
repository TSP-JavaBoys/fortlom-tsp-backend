package com.example.fortlomtsp.backend.mapping;


import com.example.fortlomtsp.backend.domain.model.entity.Forum;
import com.example.fortlomtsp.backend.resource.FanaticForum.CreateFanaticForumResource;
import com.example.fortlomtsp.backend.resource.FanaticForum.FanaticForumResource;
import com.example.fortlomtsp.backend.resource.FanaticForum.UpdateFanaticForumResource;
import com.example.fortlomtsp.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class FanaticForumMapper {
    @Autowired
    EnhancedModelMapper mapper;

    public FanaticForumResource toResource(Forum model) {
        return mapper.map(model, FanaticForumResource.class);
    }

    public Page<FanaticForumResource> modelListToPage(List<Forum> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, FanaticForumResource.class), pageable, modelList.size());
    }
    public Forum toModel(CreateFanaticForumResource resource) {
        return mapper.map(resource, Forum.class);
    }

    public Forum toModel(UpdateFanaticForumResource resource) {
        return mapper.map(resource, Forum.class);
    }
}
