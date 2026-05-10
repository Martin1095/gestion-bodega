package com.example.gestionbodega.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gestionbodega.DTO.PedidoDTO;
import com.example.gestionbodega.model.Pedido;
import com.example.gestionbodega.service.PedidoService;

@RestController
@RequestMapping("/api/v1/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    // Metodo para obtener todos los pedidos
    @GetMapping
    public ResponseEntity<List<PedidoDTO>> obtenerPedidos() {
        List<PedidoDTO> pedidos = pedidoService.obtenerPedidos();
        if (pedidos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(pedidos, HttpStatus.OK);
    }

    // Metodo para obtener un pedido por su ID
    @GetMapping("/{id_pedido}")
    public ResponseEntity<PedidoDTO> obtenerPedidoPorId(@PathVariable Integer id_pedido) {
        try {
            PedidoDTO pedido = pedidoService.obtenerPedidoPorId(id_pedido);
            return new ResponseEntity<>(pedido, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Metodo para añadir un pedido nuevo
    @PostMapping
    public ResponseEntity<Pedido> agregarPedido(@RequestBody Pedido pedido) {
        try {
            Pedido nuevoPedido = pedidoService.agregarPedido(pedido);
            return new ResponseEntity<>(nuevoPedido, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // Metodo para actualizar un pedido
    @PostMapping("/{id_pedido}")
    public ResponseEntity<Pedido> actualizarPedido(@PathVariable Integer id_pedido, @RequestBody Pedido pedido) {
        try {
            Pedido pedidoActualizado = pedidoService.actualizarPedido(id_pedido, pedido);
            return new ResponseEntity<>(pedidoActualizado, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    

    // Metodo para eliminar un pedido por su ID
    @DeleteMapping("/eliminar/{id_pedido}")
    public ResponseEntity<String> eliminarPedido(@PathVariable Integer id_pedido) {
        String mensaje = pedidoService.eliminarPedido(id_pedido);

        if (mensaje.contains("eliminado")) {
            return new ResponseEntity<>(mensaje, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(mensaje, HttpStatus.NOT_FOUND);
            
        }
        
    }
}