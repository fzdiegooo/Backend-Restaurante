package com.example.backendrestaurante.models.dto.inventario;

public record SubCategoriaRequest(
        String nombre,
        String descripcion,
        Long id_categoria
) {
}
