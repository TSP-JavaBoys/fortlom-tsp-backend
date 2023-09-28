package com.example.fortlomtsp.backend.mapping;

import com.example.fortlomtsp.backend.domain.model.entity.Album;
import com.example.fortlomtsp.backend.resource.Album.AlbumResource;
import com.example.fortlomtsp.backend.resource.Album.CreateAlbumResource;
import com.example.fortlomtsp.shared.mapping.EnhancedModelMapper;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Mapper
public class AlbumMapper {
    @Autowired
    EnhancedModelMapper mapper;

    public AlbumResource toResource(Album model) {
        return mapper.map(model, AlbumResource.class);
    }

    public Page<AlbumResource> modelListToPage(List<Album> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, AlbumResource.class), pageable, modelList.size());
    }
    public Album toModel(CreateAlbumResource resource) {
        return mapper.map(resource, Album.class);
    }
}
