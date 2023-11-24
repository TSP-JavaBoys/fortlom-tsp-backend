package com.example.fortlomtsp.backend.mapping;



import com.example.fortlomtsp.backend.domain.model.entity.Fanatic;
import com.example.fortlomtsp.backend.resource.fanatic.CreateFanaticResource;
import com.example.fortlomtsp.backend.resource.fanatic.FanaticResource;
import com.example.fortlomtsp.backend.resource.fanatic.UpdateFanaticResource;
import com.example.fortlomtsp.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import java.io.Serializable;
import java.util.List;
public class FanaticMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    public FanaticResource toResource(Fanatic model) {
        return mapper.map(model, FanaticResource.class);
    }

    public Page<FanaticResource> modelListToPage(List<Fanatic> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, FanaticResource.class), pageable, modelList.size());
    }
    public Fanatic toModel(CreateFanaticResource resource) {
        return mapper.map(resource, Fanatic.class);
    }

    public Fanatic toModel(UpdateFanaticResource resource) {
        return mapper.map(resource, Fanatic.class);
    }

}
