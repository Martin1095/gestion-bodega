package com.example.gestionbodega.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.gestionbodega.DTO.PedidoDTO;
import com.example.gestionbodega.model.Pedido;
import com.example.gestionbodega.repository.PedidoRepository;

public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    //Metodo para obtener todos los pedidos
    public List<PedidoDTO> obtenerPedidios(){
        return pedidoRepository.findAll().stream()
                .map(this::convertirAPedidoDTO)
                .toList();
    }

    //Metodo para convertir a PedidoDTO
    private PedidoDTO convertirAPedidoDTO(Pedido pedido) {
        PedidoDTO pedidoDTO = new PedidoDTO();
        pedidoDTO.setId_pedido(pedido.getId_pedido());
        pedidoDTO.setFecha_entrega(pedido.getFecha_entrega());
        pedidoDTO.setDireccion_entrega(pedido.getDireccion_entrega());
        pedidoDTO.setEstado_pedido(pedido.getEstado_pedido());
        pedidoDTO.setId_cliente(pedido.getCliente().getId_cliente());
        return pedidoDTO;
    }

}
