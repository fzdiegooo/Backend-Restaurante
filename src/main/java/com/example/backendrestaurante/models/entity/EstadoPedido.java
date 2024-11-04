package com.example.backendrestaurante.models.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name= "EstadoPedido")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EstadoPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
}
