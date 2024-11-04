package com.example.backendrestaurante.models.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "TipoDocumento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TipoDocumento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
}
