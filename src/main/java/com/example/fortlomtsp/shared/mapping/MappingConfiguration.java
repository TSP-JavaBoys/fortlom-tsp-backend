package com.example.fortlomtsp.shared.mapping;
import com.example.fortlomtsp.backend.mapping.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("enhancedModelMapperConfiguration")
public class MappingConfiguration {
    @Bean
    public EnhancedModelMapper modelMapper() {
        return new EnhancedModelMapper();
    }
    @Bean
    public ArtistMapper artistMapper() {
        return new ArtistMapper();
    }
    @Bean
    public FanaticMapper fanaticMapper() {
        return new FanaticMapper();
    }
    @Bean
    public TagMapper tagMapper() {
        return new TagMapper();
    }

    @Bean
    public UserAccountMapper UserAccountMapper() {
        return new UserAccountMapper();
    }
    @Bean
    public AdminMapper adminMapper() {
        return new AdminMapper();
    }

    @Bean
    public EventMapper eventMapper() {
        return new EventMapper();
    }

    @Bean
    public PublicationMapper publicationMapper() {
        return new PublicationMapper();
    }

    @Bean
    public ImageMapper imageMapper() {
        return new ImageMapper();
    }



    @Bean
    public RateMapper rateMapper() {
        return new RateMapper();
    }

    @Bean
    public FollowMapper followMapper() {
        return new FollowMapper();
    }

    @Bean
    public OpinionMapper opinionMapper() {
        return new OpinionMapper();
    }

    @Bean
    public ForumCommentMapper forumCommentMapper() {
        return new ForumCommentMapper();
    }

    @Bean
    public PublicationCommentMapper publicationCommentMapper() {
        return new PublicationCommentMapper();
    }

    @Bean
    public ComplaintMapper complaintMapper() {
        return new ComplaintMapper();
    }

}
