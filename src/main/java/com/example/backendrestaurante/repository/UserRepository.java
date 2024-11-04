package com.example.backendrestaurante.repository;

import com.example.backendrestaurante.models.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<Usuario, UUID> {

    Optional<Usuario> findByUsername(String username);
}
