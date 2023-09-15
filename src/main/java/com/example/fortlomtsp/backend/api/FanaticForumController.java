package com.example.fortlomtsp.backend.api;



import com.example.fortlomtsp.backend.domain.model.entity.Forum;
import com.example.fortlomtsp.backend.domain.service.FanaticForumService;
import com.example.fortlomtsp.backend.mapping.FanaticForumMapper;
import com.example.fortlomtsp.backend.resource.FanaticForum.CreateFanaticForumResource;
import com.example.fortlomtsp.backend.resource.FanaticForum.FanaticForumResource;
import com.example.fortlomtsp.backend.resource.FanaticForum.UpdateFanaticForumResource;
import com.example.fortlomtsp.backend.resource.event.EventResource;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin()
@RequestMapping("/api/v1/fanaticforumservice")
public class FanaticForumController {

    @Autowired
    private FanaticForumService fanaticForumService;

    @Autowired
    private FanaticForumMapper mapper;
    @Autowired
    private ModelMapper mapping;
    @GetMapping("/forums")
    public Page<FanaticForumResource> getAllForums(Pageable pageable) {
        return mapper.modelListToPage(fanaticForumService.getAllForums(), pageable);
    }
    @GetMapping("/forums/{forumId}")
    public FanaticForumResource getForumById(@PathVariable Long forumId) {
        return mapper.toResource(fanaticForumService.getForumById(forumId));
    }
    @GetMapping("/fanatics/{fanaticId}/forums")
    public ResponseEntity<Page<FanaticForumResource>> getAllForumsByusersId(@PathVariable Long fanaticId, Pageable pageable) {

        return ResponseEntity.ok(mapper.modelListToPage(fanaticForumService.getForumsByFanaticId(fanaticId), pageable));
    }
    @PostMapping("/fanatics/{fanaticId}/forums")
    public ResponseEntity<FanaticForumResource> createForum(@PathVariable Long fanaticId,@RequestBody CreateFanaticForumResource request) {
        Forum forum = mapping.map(request, Forum.class);
        return ResponseEntity.ok(mapping.map(fanaticForumService.createFanaticForum(fanaticId, forum), FanaticForumResource.class));
    }
    @DeleteMapping("/forums/{forumId}")
    public ResponseEntity<?> deleteForum(@PathVariable Long forumId) {
        return fanaticForumService.delete(forumId);
    }
    @PutMapping("/chagetules/{forumId}")
    public FanaticForumResource updateForum(@PathVariable Long forumId, @RequestBody UpdateFanaticForumResource request) {
        return mapper.toResource(fanaticForumService.updateRules(forumId, request.getForumrules()));
    }












}
