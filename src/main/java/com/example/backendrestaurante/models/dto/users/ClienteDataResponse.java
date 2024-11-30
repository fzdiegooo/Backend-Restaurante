package com.example.backendrestaurante.models.dto.users;

import com.example.backendrestaurante.models.entity.TipoDocumento;
import lombok.Builder;

@Builder
public record ClienteDataResponse(

    String id,
    String nombre,
    String apellidos,
    String numDocumento,
    String username, //Funciona como un email
    String direccion,
    String telefono,
    TipoDocumento tipoDocumento
) {}
