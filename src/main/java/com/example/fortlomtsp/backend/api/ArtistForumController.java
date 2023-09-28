package com.example.fortlomtsp.backend.api;

import com.example.fortlomtsp.backend.domain.model.entity.Forum;
import com.example.fortlomtsp.backend.domain.service.ArtistForumService;
import com.example.fortlomtsp.backend.mapping.FanaticForumMapper;
import com.example.fortlomtsp.backend.resource.FanaticForum.CreateFanaticForumResource;
import com.example.fortlomtsp.backend.resource.FanaticForum.FanaticForumResource;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin()
@RequestMapping("/api/v1/artistforumservice")
public class ArtistForumController {
    private final ArtistForumService artistForumService;
    private final ModelMapper mapping;
    private final FanaticForumMapper mapper;

    public ArtistForumController(ArtistForumService artistForumService, ModelMapper mapping, FanaticForumMapper mapper) {
        this.artistForumService = artistForumService;
        this.mapping = mapping;
        this.mapper = mapper;
    }

    @GetMapping("/artists/{artistId}/forums")
    public ResponseEntity<Page<FanaticForumResource>> getAllForumsByUserId(@PathVariable Long artistId, Pageable pageable) {
        return ResponseEntity.ok(mapper.modelListToPage(artistForumService.getByArtistId(artistId), pageable));
    }

    @PostMapping("/artists/{artistId}/forums")
    public ResponseEntity<FanaticForumResource> createForum(@PathVariable Long artistId,@RequestBody CreateFanaticForumResource request) {
        Forum forum = mapping.map(request, Forum.class);
        return ResponseEntity.ok(mapping.map(artistForumService.create(artistId, forum), FanaticForumResource.class));
    }
}
