package com.example.backendrestaurante.controllers.auth;

import com.example.backendrestaurante.models.dto.auth.AuthResponse;
import com.example.backendrestaurante.models.dto.auth.LoginRequest;
import com.example.backendrestaurante.models.dto.users.UserAuthDto;
import com.example.backendrestaurante.models.entity.Usuario;
import com.example.backendrestaurante.services.auth.AuthService;
import com.example.backendrestaurante.services.auth.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthCotroller {
    private final AuthService authService;
    private final JwtService jwtService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest login) {
        return ResponseEntity.ok(authService.login(login));
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody UserAuthDto user){
        return ResponseEntity.ok(authService.register(user));
    }
    @PostMapping("/validate")
    public ResponseEntity<Map<String, Object>> validate(@RequestBody AuthResponse request){
        return ResponseEntity.ok(authService.validate(request.token()));
    }
}
