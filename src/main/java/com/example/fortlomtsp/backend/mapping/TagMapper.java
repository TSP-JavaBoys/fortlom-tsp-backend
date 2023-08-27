package com.example.fortlomtsp.backend.mapping;

import com.example.fortlomtsp.backend.domain.model.entity.Tag;
import com.example.fortlomtsp.backend.resource.tag.CreateTagResource;
import com.example.fortlomtsp.backend.resource.tag.TagResource;
import com.example.fortlomtsp.shared.mapping.EnhancedModelMapper;
;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.io.Serializable;
public class TagMapper implements Serializable{

    @Autowired
    EnhancedModelMapper mapper;

    public TagResource toResource(Tag model) {
        return mapper.map(model, TagResource.class);
    }

    public Page<TagResource> modelListToPage(List<Tag> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, TagResource.class), pageable, modelList.size());
    }
    public Tag toModel(CreateTagResource resource) {
        return mapper.map(resource, Tag.class);
    }
}
