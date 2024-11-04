package com.example.backendrestaurante.models.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "TipoEntrega")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Builder
public class TipoEntrega {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;

}
