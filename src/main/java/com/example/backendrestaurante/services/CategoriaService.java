package com.example.backendrestaurante.services;

import com.example.backendrestaurante.models.entity.Categoria;
import com.example.backendrestaurante.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    public ArrayList<Categoria> getCategorias(){
        return (ArrayList<Categoria>) categoriaRepository.findAll();
    }


}


