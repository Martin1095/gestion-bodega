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

import com.example.gestionbodega.DTO.ArticuloDTO;
import com.example.gestionbodega.model.Articulo;
import com.example.gestionbodega.service.ArticuloService;

@RestController
@RequestMapping("/api/v1/articulos")
public class ArticuloController {

    @Autowired
    private ArticuloService articuloService;
    // GET ALL
    @GetMapping
    public ResponseEntity<List<ArticuloDTO>> obtenerTodos() {
        List<ArticuloDTO> lista = articuloService.obtenerTodos();
        if (lista.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }
    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<ArticuloDTO> buscarPorId(@PathVariable Integer id){
        try {
            ArticuloDTO articulo = articuloService.buscarPorId(id);
            return new ResponseEntity<>(articulo, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    // POST
    @PostMapping
    public ResponseEntity<Articulo> guardar(@RequestBody Articulo articulo) {
        try {
            Articulo nuevo = articuloService.guardarArticulo(articulo);
            return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    // PATCH
    @PatchMapping("/{id}")
    public ResponseEntity<Articulo> actualizar(@PathVariable Integer id, @RequestBody Articulo articulo) {
        try {
            Articulo actualizado = articuloService.actualizarArticulo(id, articulo);
            return new ResponseEntity<>(actualizado, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id) {
        String resultado = articuloService.eliminarArticulo(id);
        if (resultado.contains("correctamente")) {
            return new ResponseEntity<>(resultado, HttpStatus.OK);
        } 
        
        return new ResponseEntity<>(resultado, HttpStatus.NOT_FOUND); 
    }
}


