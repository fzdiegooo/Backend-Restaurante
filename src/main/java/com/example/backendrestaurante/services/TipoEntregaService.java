package com.example.backendrestaurante.services;

import com.example.backendrestaurante.models.entity.TipoEntrega;
import com.example.backendrestaurante.repository.TipoEntregaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoEntregaService {
    @Autowired
    private TipoEntregaRepository tipoEntregaRepository;

    public List<TipoEntrega> obtenerTodos() {
        return tipoEntregaRepository.findAll();
    }

    public Optional<TipoEntrega> obtenerPorId(int id) {
        return tipoEntregaRepository.findById(id);
    }

    public TipoEntrega guardar(TipoEntrega tipoEntrega) {
        return tipoEntregaRepository.save(tipoEntrega);
    }

    public void eliminar(int id) {
        tipoEntregaRepository.deleteById(id);
    }
}
