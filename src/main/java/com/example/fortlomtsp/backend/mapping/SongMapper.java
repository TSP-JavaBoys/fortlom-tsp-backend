package com.example.fortlomtsp.backend.mapping;

import com.example.fortlomtsp.backend.domain.model.entity.Song;
import com.example.fortlomtsp.backend.resource.Song.CreateSongResource;
import com.example.fortlomtsp.backend.resource.Song.SongResource;
import com.example.fortlomtsp.shared.mapping.EnhancedModelMapper;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Auditable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;


public class SongMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    public SongResource toResource(Song model) {
        return mapper.map(model, SongResource.class);
    }

    public Page<SongResource> modelListToPage(List<Song> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, SongResource.class), pageable, modelList.size());
    }
    public Song toModel(CreateSongResource resource) {
        return mapper.map(resource, Song.class);
    }
}
