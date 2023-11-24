package com.example.fortlomtsp.backend.domain.service;

import com.example.fortlomtsp.backend.domain.model.entity.UserAccount;

import java.util.Optional;

public interface UserAccountService {
    Optional<UserAccount> getbyNombreUsuarioOrEmail(String nombreOremail);

    void save(UserAccount usuario);

    Optional<UserAccount> getByTokenPassword(String tokenPassword);
    UserAccount getById(Long userId);
    boolean existsById(Long id);

    UserAccount updateprofile(Long userId, UserAccount request);

    UserAccount updatepassword(Long userId, UserAccount request);

    UserAccount getByUsername(String Username);
}
