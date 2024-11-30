package com.example.backendrestaurante.models.dto.auth;


import lombok.Builder;

@Builder
public record LoginRequest(
String username,
String password
) {
}
