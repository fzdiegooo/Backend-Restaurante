package com.example.backendrestaurante.services;

import com.example.backendrestaurante.models.dto.auth.AuthResponse;
import com.example.backendrestaurante.models.dto.auth.UserRolResponse;
import com.example.backendrestaurante.models.dto.users.ClienteDataResponse;
import com.example.backendrestaurante.models.entity.Rol;
import com.example.backendrestaurante.models.entity.Usuario;
import com.example.backendrestaurante.repository.user.RolRepository;
import com.example.backendrestaurante.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    RolRepository rolRepository;
    private final WebClient webClient;

    public UserService(WebClient webClient) {
        this.webClient = webClient;
    }

    public UserRolResponse getRolByUser(String username){
        Usuario userEncontrado = userRepository.findByUsername(username).orElseThrow();
        System.out.println("usuario: "+ userEncontrado);
        return UserRolResponse.builder()
                .rol(String.valueOf(rolRepository.findById(userEncontrado.getRol().getId())))
                .username(username)
                .build();
    }

    public ClienteDataResponse getClienteData(String username){
        Usuario userEncontrado = userRepository.findByUsername(username).orElseThrow();
        return ClienteDataResponse.builder()
                .id(userEncontrado.getId())
                .nombre(userEncontrado.getNombre())
                .apellidos(userEncontrado.getApellidos())
                .numDocumento(userEncontrado.getNumDocumento())
                .username(userEncontrado.getUsername())
                .telefono(userEncontrado.getTelefono())
                .direccion(userEncontrado.getDireccion())
                .tipoDocumento(userEncontrado.getTipoDocumento())
                .build();
    }



    public String getRazonSocial(String numero) {
        // Usando LinkedMultiValueMap para agregar los parámetros
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("numero", numero);
        params.add("token", "apis-token-11065.eyLRCDPDmO4luZNuB85rd3UeQmmZwcDeusername");

        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("")  // Ruta de la API
                        .queryParams(params) // Agrega los parámetros de la consulta
                        .build())
                .retrieve()
                .onStatus(status -> status.is4xxClientError() || status.is5xxServerError(),
                        clientResponse -> {
                            // Manejar errores HTTP 4xx o 5xx
                            return clientResponse.bodyToMono(String.class)
                                    .flatMap(errorBody -> {
                                        // Puedes extraer y procesar el cuerpo de la respuesta de error si lo necesitas
                                        return Mono.error(new RuntimeException("Error de API: " + errorBody));
                                    });
                        })
                .bodyToMono(String.class)  // Devuelve la respuesta JSON como un String
                .block();  // Bloquea la respuesta (sincrónico)
    }
}
