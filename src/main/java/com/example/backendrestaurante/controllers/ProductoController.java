package com.example.backendrestaurante.controllers;

import com.example.backendrestaurante.models.entity.Producto;
import com.example.backendrestaurante.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    @Autowired
    ProductoService ps;

    @GetMapping
    public List<Producto> getProductos() {
        return ps.getProducts();
    }

    @GetMapping(path = "/{id}")
    public Optional<Producto> getProductos(@PathVariable String id) {
        return ps.getProductById(id);
    }

    @PostMapping
    public Producto crearProductos(@RequestBody Producto producto) {
        return ps.saveProduct(producto);
    }

    @GetMapping("/filter")
    public List<Producto> buscarConFiltros(
            @RequestParam(required = false) String search,
            @RequestParam(required = false) List<String> categorias) {
        return ps.withFilters(search, categorias);
    }
}
