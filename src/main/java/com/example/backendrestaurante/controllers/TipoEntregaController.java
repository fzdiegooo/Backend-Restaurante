package com.example.backendrestaurante.controllers;

import com.example.backendrestaurante.models.entity.TipoEntrega;
import com.example.backendrestaurante.services.TipoEntregaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipo-entrega")
public class TipoEntregaController {
    @Autowired
    private TipoEntregaService tipoEntregaService;

    @GetMapping
    public List<TipoEntrega> obtenerTodos() {
        return tipoEntregaService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoEntrega> obtenerPorId(@PathVariable int id) {
        return tipoEntregaService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public TipoEntrega guardar(@RequestBody TipoEntrega tipoEntrega) {
        return tipoEntregaService.guardar(tipoEntrega);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id) {
        if (tipoEntregaService.obtenerPorId(id).isPresent()) {
            tipoEntregaService.eliminar(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
