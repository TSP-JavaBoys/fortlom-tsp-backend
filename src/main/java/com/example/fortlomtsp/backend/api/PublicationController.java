package com.example.fortlomtsp.backend.api;

import com.example.fortlomtsp.backend.domain.model.entity.Publication;
import com.example.fortlomtsp.backend.domain.service.PublicationService;
import com.example.fortlomtsp.backend.mapping.PublicationMapper;
import com.example.fortlomtsp.backend.resource.publication.CreatePublicationResource;
import com.example.fortlomtsp.backend.resource.publication.PublicationResource;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/api/v1/contentservice")
public class PublicationController {
    @Autowired
    private PublicationService publicationService;

    @Autowired
    private PublicationMapper mapper;

    @Autowired
    private ModelMapper mapping;

    @GetMapping("/publications")
    public Page<PublicationResource> getAllPublications(Pageable pageable) {
        return mapper.modelListToPage(publicationService.getAll(), pageable);
    }

    @GetMapping("/publications/{publicationId}")
    public PublicationResource getPublicationById(@PathVariable("publicationId") Long publicationId) {
        return mapper.toResource(publicationService.getById(publicationId));
    }
    @PostMapping("/artists/{artistId}/type/{type}/publications")
    public ResponseEntity<PublicationResource> createPublication(@PathVariable Long artistId,@PathVariable String type,@RequestBody CreatePublicationResource request) {
        Publication publication = mapping.map(request, Publication.class);
        return ResponseEntity.ok(mapping.map(publicationService.create(artistId, publication,type), PublicationResource.class));
    }
    @DeleteMapping("/publications/{publicationId}")
    public ResponseEntity<?> deletePublication(@PathVariable Long publicationId) {
        return publicationService.delete(publicationId);
    }
    @GetMapping("/artists/{artistId}/publications")
    public ResponseEntity<Page<PublicationResource>> getAllPublicationByArtistId(@PathVariable Long artistId,Pageable pageable) {

        return ResponseEntity.ok(mapper.modelListToPage(publicationService.getPublicationByArtistId(artistId), pageable));
    }
    @GetMapping("publications/check/{publicationId}")
    public boolean existspublication(@PathVariable("publicationId") Long publicationId){
        return publicationService.existspublication(publicationId);
    }
}
