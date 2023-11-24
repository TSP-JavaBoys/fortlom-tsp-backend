package com.example.fortlomtsp.backend.api;


import com.example.fortlomtsp.backend.domain.model.entity.Image;
import com.example.fortlomtsp.backend.domain.service.CloudinaryService;
import com.example.fortlomtsp.backend.domain.service.ImageService;
import com.example.fortlomtsp.backend.mapping.ImageMapper;
import com.example.fortlomtsp.backend.resource.Image.ImageResource;
import com.example.fortlomtsp.shared.exception.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Map;;
@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/api/v1/multimediaservice")
public class ImagePublicationController {

    @Autowired
    private ImageService imageService;

    @Autowired
    private CloudinaryService cloudinaryService;

    @Autowired
    private ImageMapper mapper;



    @PostMapping("/upload/publications/{publicationsId}/images")
    public ResponseEntity<ImageResource> createimageforpublication(@PathVariable Long publicationsId, @RequestParam MultipartFile multipartFile) throws IOException {
        BufferedImage bi = ImageIO.read(multipartFile.getInputStream());
        if(bi == null){
            return new ResponseEntity(new Message("imagen no válida"), HttpStatus.BAD_REQUEST);
        }

        Map result = cloudinaryService.upload(multipartFile);
        Image image=new Image();
        image.setImagenUrl((String)result.get("url"));
        image.setImagenId( (String)result.get("public_id"));

        return ResponseEntity.ok( mapper.toResource(imageService.createforpublication(publicationsId,image)));
    }
    @GetMapping("/publications/{publicationsId}/images")
    public ResponseEntity<Page<ImageResource>> getImageByPublicationId(@PathVariable Long publicationsId, Pageable pageable) {

        return ResponseEntity.ok(mapper.modelListToPage(imageService.getImageByPublicationId(publicationsId), pageable));
    }


}
