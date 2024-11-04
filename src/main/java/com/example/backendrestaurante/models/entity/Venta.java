package com.example.backendrestaurante.models.entity;

import com.example.backendrestaurante.models.entity.correlativos.Correlativo;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name= "Venta")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private LocalDateTime fechaEmision;
    private LocalDateTime fechaVencimiento;
    private LocalDateTime fechapago;
    private String formapago;
    private Double impuesto;
    private Double gravada;
    private Double total;
    private String nota;
    private String datosPago;


    @OneToOne
    @JoinColumn(name = "correlativoId")
    private Correlativo correlativo;

    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL)
    private List<DetalleVenta> detalleVentaList;

    @ManyToOne
    @JoinColumn(name = "usuarioId")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "pedidoId")
    private Pedido pedido;
}
