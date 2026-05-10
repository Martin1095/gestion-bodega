package com.example.gestionbodega.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gestionbodega.DTO.TrabajadorDTO;
import com.example.gestionbodega.model.Trabajador;
import com.example.gestionbodega.service.TrabajadorService;

@RestController
@RequestMapping("/api/v1/trabajadores")
public class TrabajadorController {
    @Autowired
    private TrabajadorService trabajadorService;

    @GetMapping
    public ResponseEntity<List<TrabajadorDTO>> obtenerTodos() {
        List<TrabajadorDTO> lista = trabajadorService.obtenerTodos();
        
        if (lista.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(lista, HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<Trabajador> guardar(@RequestBody Trabajador trabajador) {

        try {
            Trabajador nuevo = trabajadorService.guardarTrabajador(trabajador);
            return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
            
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


}
