package com.example.gestionbodega.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import com.example.gestionbodega.model.Bodega;
import com.example.gestionbodega.service.BodegaService;

@RestController
@RequestMapping("/api/v1/bodegas")

public class BodegaController {

    @Autowired
    private BodegaService service;

    @GetMapping
    public ResponseEntity<List<Bodega>> listar(){
        return new ResponseEntity<>(service.listar(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Bodega> guardar(@RequestBody Bodega bodega){
        return new ResponseEntity<>(service.guardar(bodega),HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bodega> buscar(@PathVariable Integer id){
        return new ResponseEntity<>(service.buscar(id),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id){
        service.eliminar(id);
        return new ResponseEntity<>("Eliminado",HttpStatus.OK);
    }

}
