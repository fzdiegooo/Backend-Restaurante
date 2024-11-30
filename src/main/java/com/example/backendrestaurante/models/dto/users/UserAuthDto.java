package com.example.backendrestaurante.models.dto.users;

import lombok.Builder;

@Builder
public record UserAuthDto(
        String id,
        String username,
        String email,
        String password,
        boolean regist,
        String rol
) {
}
