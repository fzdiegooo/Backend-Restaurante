package com.example.backendrestaurante.repository.user;

import com.example.backendrestaurante.models.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
@Service
public interface UserRepository extends JpaRepository<Usuario, UUID> {

    Optional<Usuario> findByUsername(String username);
}
