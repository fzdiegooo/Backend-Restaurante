package com.example.backendrestaurante.models.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name= "DetallePedido")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetallePedido {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private Double precioNeto;
    private int cantidad;

    @ManyToOne
    @JoinColumn(name = "productoId")
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "pedidoId")
    @JsonBackReference
    private Pedido pedido;
}
