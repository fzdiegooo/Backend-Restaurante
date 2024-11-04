package com.example.backendrestaurante.models.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "Privilegio")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Privilegio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;

    @ManyToMany(mappedBy = "privilegios")
    private List<Rol> roles;
}
