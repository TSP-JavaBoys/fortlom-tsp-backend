package com.example.fortlomtsp.backend.mapping;


import com.example.fortlomtsp.backend.domain.model.entity.ForumComment;
import com.example.fortlomtsp.backend.resource.ForumComment.CreateForumCommentResource;
import com.example.fortlomtsp.backend.resource.ForumComment.ForumCommentResource;
import com.example.fortlomtsp.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class ForumCommentMapper {

    @Autowired
    EnhancedModelMapper mapper;



    public ForumCommentResource toResource(ForumComment model) {
        return mapper.map(model, ForumCommentResource.class);
    }

    public Page<ForumCommentResource> modelListToPage(List<ForumComment> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, ForumCommentResource.class), pageable, modelList.size());
    }
    public ForumComment toModel(CreateForumCommentResource resource) {
        return mapper.map(resource, ForumComment.class);
    }
}
