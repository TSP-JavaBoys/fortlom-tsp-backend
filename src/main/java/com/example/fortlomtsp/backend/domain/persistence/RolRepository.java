package com.example.fortlomtsp.backend.domain.persistence;

import com.example.fortlomtsp.backend.domain.model.entity.Rol;
import com.example.fortlomtsp.backend.domain.model.enumeration.Rolname;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface RolRepository extends JpaRepository<Rol,Long> {
    Optional<Rol> findByName(Rolname name);
    boolean existsByName(Rolname name);
}
