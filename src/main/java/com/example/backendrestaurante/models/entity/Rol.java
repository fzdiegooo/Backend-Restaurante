package com.example.backendrestaurante.models.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "Rol")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "rolPrivilegio",
            joinColumns = @JoinColumn(name = "rolId"),
            inverseJoinColumns = @JoinColumn(name = "privilegioId")
    )
    private List<Privilegio> privilegios;
}
