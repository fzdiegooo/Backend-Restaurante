package com.example.backendrestaurante.models.entity.correlativos;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "Correlativo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Correlativo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private Long numero;

    @ManyToOne
    @JoinColumn(name = "idNumeracionComprobante")
    private NumeracionComprobante numeracioncomprobante;

}
