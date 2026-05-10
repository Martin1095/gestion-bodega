package com.example.gestionbodega.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gestionbodega.DTO.RecepcionDTO;
import com.example.gestionbodega.model.Recepcion;
import com.example.gestionbodega.service.RecepcionService;

@RestController
@RequestMapping("/api/v1/recepciones")

public class RecepcionController {

    @Autowired
    private RecepcionService recepcionService;

    @GetMapping
    public ResponseEntity<List<RecepcionDTO>> obtenerTodos() {
        List<RecepcionDTO> lista = recepcionService.obtenerTodos();
        if (lista.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Recepcion> guardar(@RequestBody Recepcion recepcion) {
        try {
            Recepcion nueva = recepcionService.guardarRecepcion(recepcion);
            return new ResponseEntity<>(nueva, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
