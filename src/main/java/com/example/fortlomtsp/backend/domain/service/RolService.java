package com.example.fortlomtsp.backend.domain.service;

import com.example.fortlomtsp.backend.domain.model.entity.Rol;
import com.example.fortlomtsp.backend.domain.model.enumeration.Rolname;

import java.util.List;
import java.util.Optional;

public interface RolService {
    Optional<Rol> findByName(Rolname name);

    void seed();

    List<Rol> getAll();
}
