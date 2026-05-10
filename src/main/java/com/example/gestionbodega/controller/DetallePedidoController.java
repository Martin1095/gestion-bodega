package com.example.gestionbodega.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.gestionbodega.DTO.DetallePedidoDTO;
import com.example.gestionbodega.model.DetallePedido;
import com.example.gestionbodega.service.DetallePedidoService;

@Controller
@RequestMapping("/api/v1/detalle_pedidos")
public class DetallePedidoController {

    @Autowired
    private DetallePedidoService detallePedidoService;

    // Metodo para convertir un DetallePedido a DetallePedidoDTO
    public DetallePedidoDTO convertirADetallePedidoDTO(DetallePedido detallePedido) {
        DetallePedidoDTO detallePedidoDTO = new DetallePedidoDTO();
        detallePedidoDTO.setId_detalle_pedido(detallePedido.getId_detalle_pedido());
        detallePedidoDTO.setCantidad(detallePedido.getCantidad());
        detallePedidoDTO.setPrecio_unitario(detallePedido.getPrecio_unitario());
        return detallePedidoDTO;
    }

    // Metodo para obtener todos los detalles de pedido
    @GetMapping
    public ResponseEntity<List<DetallePedidoDTO>> obtenerDetallesPedido() {
        List<DetallePedidoDTO> detallesPedido = detallePedidoService.obtenerDetallesPedido();
        if (detallesPedido.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(detallesPedido, HttpStatus.OK);
    }

    // Metodo para obtener un detalle de pedido por su ID
    @GetMapping("/{id_detalle_pedido}")
    public ResponseEntity<DetallePedidoDTO> obtenerDetallePedidoPorId(@PathVariable Integer id_detalle_pedido) {
        try {
            DetallePedidoDTO detallePedido = detallePedidoService.obtenerDetallePedidoPorId(id_detalle_pedido);
            return new ResponseEntity<>(detallePedido, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Metodo para añadir un nuevo detalle de pedido
    @PostMapping
    public ResponseEntity<DetallePedido> agregarDetallePedido(@RequestBody DetallePedido detallePedido) {
        try {
            DetallePedido nuevoDetallePedido = detallePedidoService.agregarDetallePedido(detallePedido);
            return new ResponseEntity<>(nuevoDetallePedido, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // Metodo para editar un detalle de pedido por su ID
    @PostMapping("/editar/{id_detalle_pedido}")
    public ResponseEntity<DetallePedido> editarDetallePedido(@PathVariable Integer id_detalle_pedido, @RequestBody DetallePedido detallePedido) {
        try {
            DetallePedido detallePedidoActualizado = detallePedidoService.editarDetallePedido(id_detalle_pedido, detallePedido);
            return new ResponseEntity<>(detallePedidoActualizado, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Metodo para eliminar un detalle de pedido por su ID
    @PostMapping("/eliminar/{id_detalle_pedido}")
    public ResponseEntity<String> eliminarDetallePedido(@PathVariable Integer id_detalle_pedido) {
        String resultadoEliminacion = detallePedidoService.eliminarDetallePedido(id_detalle_pedido);
        if (resultadoEliminacion.contains("exitosamente")) {
            return new ResponseEntity<>(resultadoEliminacion, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(resultadoEliminacion, HttpStatus.NOT_FOUND);
        }
    }

}