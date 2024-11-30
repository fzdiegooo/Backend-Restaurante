package com.example.backendrestaurante.repository;

import com.example.backendrestaurante.models.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    @Query("SELECT p FROM Pedido p JOIN FETCH p.detallePedidos dp WHERE p.usuario.id = :usuarioId")
    List<Pedido> findAllByUsuarioIdWithDetalles(@Param("usuarioId") String usuarioId);
}
