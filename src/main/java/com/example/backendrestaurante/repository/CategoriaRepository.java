package com.example.backendrestaurante.repository;

import com.example.backendrestaurante.models.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria,Long> {


}
