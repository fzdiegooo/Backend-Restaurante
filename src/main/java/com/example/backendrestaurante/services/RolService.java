package com.example.backendrestaurante.services;

import com.example.backendrestaurante.models.entity.Rol;
import com.example.backendrestaurante.repository.user.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RolService {
    @Autowired
    RolRepository rolRepository;

    private Optional<Rol> getRolById(Long id){
        return rolRepository.findById(id);
    }
}
