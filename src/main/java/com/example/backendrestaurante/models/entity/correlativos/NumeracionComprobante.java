package com.example.backendrestaurante.models.entity.correlativos;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "NumeraciónComprobante")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NumeracionComprobante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long numeracion;
    private String descripcion;

    @OneToMany(mappedBy = "numeracioncomprobante",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Correlativo> correlativos;

    @ManyToOne
    @JoinColumn(name = "tipocomprobante")
    private TipoComprobante tipocomprobante;

}
