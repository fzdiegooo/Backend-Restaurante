package com.example.backendrestaurante.models.dto.users;

import lombok.Builder;

@Builder
public record UserRequest(
        String id,
        boolean regist,
        String email,
        String username,
        String rol
) {
}
