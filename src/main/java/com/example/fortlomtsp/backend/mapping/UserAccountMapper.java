package com.example.fortlomtsp.backend.mapping;





import com.example.fortlomtsp.backend.domain.model.entity.UserAccount;
import com.example.fortlomtsp.backend.resource.useraccoount.UpdatePersonResource;
import com.example.fortlomtsp.backend.resource.useraccoount.UserAccountResource;
import com.example.fortlomtsp.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.io.Serializable;
public class UserAccountMapper {

    @Autowired
    EnhancedModelMapper mapper;


    public UserAccountResource toResource(UserAccount model) {
        return mapper.map(model, UserAccountResource.class);
    }

    public Page<UserAccountResource> modelListToPage(List<UserAccount> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, UserAccountResource.class), pageable, modelList.size());
    }
    public UserAccount toModel(UpdatePersonResource resource) {
        return mapper.map(resource, UserAccount.class);
    }

}
