package com.example.backendrestaurante.repository;

import com.example.backendrestaurante.models.entity.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProductoRepository extends JpaRepository<Producto, String>, JpaSpecificationExecutor<Producto> {
    Page<Producto> findAll(Pageable pageable);
}
