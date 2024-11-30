package com.example.backendrestaurante.services;

import com.example.backendrestaurante.models.entity.Pedido;
import com.example.backendrestaurante.repository.PedidoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    public void createPedido(Pedido pedido){
        pedidoRepository.save(pedido);
    }

    public void deletePedido(Long id){
        pedidoRepository.deleteById(id);
    }

    public Pedido getPedidoById(Long id){
        return pedidoRepository.findById(id).orElseThrow();
    }

    public void updatePedido(Pedido pedido){
        pedidoRepository.save(pedido);
    }

    @Transactional
    public Pedido guardarPedido(Pedido pedido) {
        pedido.getDetallePedidos().forEach(detalle -> detalle.setPedido(pedido)); // Asocia cada detalle al pedido
        return pedidoRepository.save(pedido);
    }

    @Transactional
    public List<Pedido> obtenerPedidosPorUsuario(String usuarioId) {
        return pedidoRepository.findAllByUsuarioIdWithDetalles(usuarioId);
    }

}
