package com.example.fortlomtsp.backend.domain.persistence;
import com.example.fortlomtsp.backend.domain.model.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface ImageRepository  extends JpaRepository<Image,Long>{

    List<Image> findByPublicationId(Long publicationId);

    List<Image> findByUserAccountId(Long UserId);
}
