package com.example.backendrestaurante.models.entity;

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
    private UUID id;
    private Double precioNeto;
    private int cantidad;

    @ManyToOne
    @JoinColumn(name = "productoId")
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "pedidoId")
    private Pedido pedido;
}
