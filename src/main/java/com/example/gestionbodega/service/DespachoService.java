package com.example.gestionbodega.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gestionbodega.model.Despacho;
import com.example.gestionbodega.repository.DespachoRepository;

@Service
public class DespachoService {

    @Autowired
    private DespachoRepository repo;

    public List<Despacho> listar(){
        return repo.findAll();
    }

    public Despacho guardar(Despacho despacho){
        return repo.save(despacho);
    }

    public Despacho buscar(Integer id){
        return repo.findById(id).orElseThrow();
    }

}
