package com.example.backendrestaurante.models.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name= "DetalleVenta")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetalleVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private Double precioNeto;
    private int cantidad;

    @ManyToOne
    @JoinColumn(name = "productoId")
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "ventaId")
    private Venta venta;

}
