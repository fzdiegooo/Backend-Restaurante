package com.example.backendrestaurante.models.dto.inventario;

public record SubCategoriaResponse(
        Long id,
        String nombre,
        String descripcion,
        String categoria
) {
}
