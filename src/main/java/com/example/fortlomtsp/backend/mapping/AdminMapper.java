package com.example.fortlomtsp.backend.mapping;

import com.example.fortlomtsp.backend.domain.model.entity.Admin;
import com.example.fortlomtsp.backend.resource.admin.AdminResource;
import com.example.fortlomtsp.backend.resource.admin.CreateAdminResource;
import com.example.fortlomtsp.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public class AdminMapper {

    @Autowired
    EnhancedModelMapper mapper;



    public AdminResource toResource(Admin model) {
        return mapper.map(model, AdminResource.class);
    }
    public AdminResource toResource(Optional<Admin> model) {
        return mapper.map(model, AdminResource.class);
    }

    public Page<AdminResource> modelListToPage(List<Admin> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, AdminResource.class), pageable, modelList.size());
    }
    public Admin toModel(CreateAdminResource resource) {
        return mapper.map(resource, Admin.class);
    }
}
