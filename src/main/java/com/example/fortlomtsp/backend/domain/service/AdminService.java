package com.example.fortlomtsp.backend.domain.service;

import com.example.fortlomtsp.backend.domain.model.entity.Admin;

import java.util.Optional;

public interface AdminService {
    Admin getById(Long adminId);
    Admin create(Admin admin);
    Optional<Admin> getbyNombreUsuario(String userName);
    Admin getbyusername(String userName);
    Boolean existsByUsername(String username);
    void save(Admin admin);
}
