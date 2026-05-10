package com.example.gestionbodega.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gestionbodega.model.Inventario;
import com.example.gestionbodega.repository.InventarioRepository;

@Service
public class InventarioService {

    @Autowired
    private InventarioRepository repo;

    public List<Inventario> listar(){
        return repo.findAll();
    }

    public Inventario guardar(Inventario inv){
        return repo.save(inv);

    }

    public Inventario buscar(Integer id){
        return repo.findById(id).orElseThrow();
    }

}
