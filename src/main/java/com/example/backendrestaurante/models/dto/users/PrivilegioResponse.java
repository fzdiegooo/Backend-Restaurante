package com.example.backendrestaurante.models.dto.users;

import lombok.Builder;

@Builder
public record PrivilegioResponse(
        Long id,
        String nombre,
        String descripcion
) {
}
