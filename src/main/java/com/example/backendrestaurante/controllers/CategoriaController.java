package com.example.backendrestaurante.controllers;

import com.example.backendrestaurante.models.entity.Categoria;
import com.example.backendrestaurante.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
