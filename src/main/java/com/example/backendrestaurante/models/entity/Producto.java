package com.example.backendrestaurante.models.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name= "Producto")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String nombre;
    private String descripcion;
    private Double precio;
    private String urlImg;
    private String cloudinaryImageId;

    @JsonIgnore
    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
    private List<DetalleVenta> detalleVentaList;

    @JsonIgnore
    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
    private List<DetallePedido> detallePedidoList;

    @ManyToOne
    @JoinColumn(name = "categoriaId")
    private Categoria categoria;

    @ManyToMany
    @JoinTable(
            name = "producto_categoria",
            joinColumns = @JoinColumn(name = "producto_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id")
    )
    private Set<Categoria> categorias = new HashSet<>();
}
