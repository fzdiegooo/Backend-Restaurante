package com.example.backendrestaurante.models.dto.inventario;

import java.util.List;

public record CategoriasRequest(
        List<CategoriaRequest> categorias
) {
}
