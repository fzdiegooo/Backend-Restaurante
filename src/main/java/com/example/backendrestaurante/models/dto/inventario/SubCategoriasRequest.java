package com.example.backendrestaurante.models.dto.inventario;

import java.util.List;

public record SubCategoriasRequest(
        Long id_categoria,
        List<SubCategoriaResponse> subCategorias
) {
}
