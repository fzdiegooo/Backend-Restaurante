package com.example.backendrestaurante.models.dto.users;

import lombok.Builder;

import java.util.List;

@Builder
public record RolResponse(
        Long id,
        String nombre,
        String descripcion,
        List<PrivilegioResponse> privilegios
) {
}
