package com.example.backendrestaurante.models.dto.auth;

import lombok.Builder;

@Builder
public record UserRolResponse(
        String username,
        String rol
) {
}
