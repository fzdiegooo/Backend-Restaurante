package com.example.backendrestaurante.controllers;

import com.example.backendrestaurante.models.entity.Categoria;
import com.example.backendrestaurante.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
    @Autowired
    private CategoriaService cs;

    @GetMapping
    public ArrayList<Categoria> getCategoria(){
        return cs.getCategorias();
    }

    @PostMapping
    public Categoria crearCategoria(@RequestBody Categoria categoria){
        return cs.saveCategoria(categoria);
    }

    @PutMapping
    public Categoria editarCategoria(@RequestBody Categoria categoria){
        return cs.editCategoria(categoria);
    }

    @DeleteMapping(path = "/{id}")
    public void eliminarCategoria(@PathVariable Long id){
        cs.deleteCategoria(id);
    }

}
