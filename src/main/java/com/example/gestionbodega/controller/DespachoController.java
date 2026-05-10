package com.example.gestionbodega.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gestionbodega.model.Despacho;
import com.example.gestionbodega.service.DespachoService;

@RestController
@RequestMapping("/api/v1/despachos")
public class DespachoController {

    @Autowired
    private DespachoService service;

    @GetMapping
    public ResponseEntity<List<Despacho>> listar(){
        return ResponseEntity.ok(service.listar());
    }

    @PostMapping
    public ResponseEntity<Despacho> guardar(@RequestBody Despacho despacho){
        return new ResponseEntity<>(service.guardar(despacho),HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Despacho> buscar(@PathVariable Integer id){
        return ResponseEntity.ok(service.buscar(id));
    }

}
