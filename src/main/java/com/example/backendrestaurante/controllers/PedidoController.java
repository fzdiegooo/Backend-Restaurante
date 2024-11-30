package com.example.backendrestaurante.controllers;

import com.example.backendrestaurante.models.entity.Pedido;
import com.example.backendrestaurante.services.PedidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping
    public ResponseEntity<Pedido> guardarPedido(@RequestBody Pedido pedido) {
        Pedido nuevoPedido = pedidoService.guardarPedido(pedido);
        return ResponseEntity.ok(nuevoPedido);
    }

    @GetMapping("/{usuarioId}")
    public ResponseEntity<List<Pedido>> obtenerPedidosPorUsuario(@PathVariable String usuarioId) {
        List<Pedido> pedidos = pedidoService.obtenerPedidosPorUsuario(usuarioId);
        return ResponseEntity.ok(pedidos);
    }
}
