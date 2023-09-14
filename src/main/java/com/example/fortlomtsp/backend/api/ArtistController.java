package com.example.fortlomtsp.backend.api;



import com.example.fortlomtsp.backend.domain.model.entity.Tag;
import com.example.fortlomtsp.backend.domain.service.ArtistService;
import com.example.fortlomtsp.backend.domain.service.TagService;
import com.example.fortlomtsp.backend.mapping.ArtistMapper;
import com.example.fortlomtsp.backend.mapping.TagMapper;
import com.example.fortlomtsp.backend.resource.artist.ArtistResource;
import com.example.fortlomtsp.backend.resource.artist.CreateArtistResource;
import com.example.fortlomtsp.backend.resource.artist.UpdateArtistResource;
import com.example.fortlomtsp.backend.resource.tag.CreateTagResource;
import com.example.fortlomtsp.backend.resource.tag.TagResource;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/api/v1/userservice/artists")
public class ArtistController {
    @Autowired
    private ArtistService artistService;

    @Autowired
    private ArtistMapper mapper;



    @Autowired
    private TagService tagService;

    @Autowired
    private TagMapper tagMapper;

    @Autowired
    private ModelMapper mapping;
    @GetMapping
    public Page<ArtistResource> getAllArists(Pageable pageable) {
        return mapper.modelListToPage(artistService.getAll(), pageable);
    }

    @GetMapping("{artistId}")
    public ArtistResource getArtistById(@PathVariable("artistId") Long artistId) {
        return mapper.toResource(artistService.getById(artistId));
    }
    @GetMapping("/username/{artistname}")
    public ArtistResource getUserByartistname(@PathVariable("artistname") String artistname) {
        return mapper.toResource(artistService.getbyUsername(artistname));
    }
    @GetMapping("/name/{artistname}/lastname/{artistlastnmae}")
    public ArtistResource getUserByartistnameandlastname(@PathVariable("artistname") String artistname,@PathVariable("artistlastnmae") String artistlastnmae) {
        return mapper.toResource(artistService.getbyNameandLastname(artistname,artistlastnmae));
    }
    @PostMapping
    public ArtistResource createArtist(@RequestBody CreateArtistResource request) {

        return mapper.toResource(artistService.create(mapper.toModel(request)));
    }
    @PostMapping("/artist/{artistId}/newtag")
    public TagResource createTag(@PathVariable Long artistId, @RequestBody CreateTagResource request) {

        Tag tag = mapping.map(request, Tag.class);
        return mapping.map(tagService.createTag(artistId, tag), TagResource.class);
    }
    @GetMapping("/artist/{artistId}/tags")
    public Page<TagResource> getAlltagsByArtistId(@PathVariable Long artistId,Pageable pageable) {
        return tagMapper.modelListToPage(tagService.getTagsByArtistId(artistId), pageable);
    }

    @PutMapping("{artistId}")
    public ArtistResource updateUser(@PathVariable Long artistId, @RequestBody UpdateArtistResource request) {
        return mapper.toResource(artistService.update(artistId, mapper.toModel(request)));
    }
    @PutMapping("/artist/{artistId}/TwitterAccount")
    public ArtistResource updateTwitterAccount(@PathVariable Long artistId, @RequestBody UpdateArtistResource request){
        return mapper.toResource(artistService.setTwitterAccount(artistId,mapper.toModel(request)));
    }
    @PutMapping("/artist/{artistId}/FacebookAccount")
    public ArtistResource updateFacebookAccount(@PathVariable Long artistId, @RequestBody UpdateArtistResource request){
        return mapper.toResource(artistService.setFacebookAccount(artistId,mapper.toModel(request)));
    }
    @PutMapping("/artist/{artistId}/InstagramAccount")
    public ArtistResource updateInstagramAccount(@PathVariable Long artistId, @RequestBody UpdateArtistResource request){
        return mapper.toResource(artistService.setInstagramAccount(artistId,mapper.toModel(request)));

    }
    @PutMapping("/artist/{artistId}/AboutMe")
    public ArtistResource updateAboutMe(@PathVariable Long artistId, @RequestBody UpdateArtistResource request){
        return mapper.toResource(artistService.setAboutMe(artistId,mapper.toModel(request)));

    }
    @DeleteMapping("{artistId}")
    public ResponseEntity<?> deletePost(@PathVariable Long artistId) {
        return artistService.delete(artistId);
    }


    @PutMapping("/upgrade/{artistId}")
    public ArtistResource updateArtistPremium(@PathVariable("artistId") Long artistId){
        return mapper.toResource(artistService.upgradeartist(artistId));
    }
    @PutMapping("/ban/{artistId}")
    public ArtistResource BanArtist(@PathVariable("artistId") Long artistId){
        return mapper.toResource(artistService.banArtist(artistId));
    }


    @GetMapping("/check/{artistId}")
    public boolean existsartistid(@PathVariable("artistId") Long artistId){
        return artistService.existsartist(artistId);
    }
    @GetMapping("/checkpremium/{artistId}")
    public boolean checkremiumartistid(@PathVariable("artistId") Long artistId){
        return artistService.ispremium(artistId);
    }





















}
