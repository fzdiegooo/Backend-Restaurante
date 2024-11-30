package com.example.backendrestaurante.controllers;

import com.example.backendrestaurante.models.dto.auth.UserRolResponse;
import com.example.backendrestaurante.models.dto.users.ClienteDataResponse;
import com.example.backendrestaurante.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/getUserRol")
    public ResponseEntity<UserRolResponse> getRolByUser(@RequestBody String username){
        return ResponseEntity.ok(userService.getRolByUser(username));
    }

    @GetMapping
    public ResponseEntity<ClienteDataResponse> getClienteData(@RequestParam String username) {
        ClienteDataResponse clienteData = userService.getClienteData(username);
        return ResponseEntity.ok(clienteData);
    }

    @PostMapping("/getRazonSocial")
    public ResponseEntity<String> getRazonSocial(@RequestParam String ruc){
        return ResponseEntity.ok(userService.getRazonSocial(ruc));
    }

}
